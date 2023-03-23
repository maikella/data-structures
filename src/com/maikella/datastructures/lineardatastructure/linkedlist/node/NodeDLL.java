package com.maikella.datastructures.lineardatastructure.linkedlist.node;

import java.util.Scanner;

import static com.maikella.datastructures.utils.Utils.checkInput;

public class NodeDLL {

   private int data;
   private NodeDLL next, head, prev;

   public NodeDLL() {}

   public NodeDLL(int data) {
      this.data = data;
   }

   public NodeDLL createLinkedList(int numInputs, Scanner scan) {

      return addElements(head, numInputs, scan);

   }

   public NodeDLL addElements(NodeDLL head, int numInputs, Scanner scan) {

      for (int i = 0; i < numInputs; i++) {
         head = push(checkInput("enter the " + (i + 1) + "° number", scan));
      }

      return head;
   }

   public NodeDLL push(int newData) {

      var newNode = new NodeDLL(newData);

      newNode.next = head;

      if (!nodeIsEmpty(head)) {
         head.prev = newNode;
      }

      head = newNode;

      return head;

   }

   public void displayList(NodeDLL head) {
      System.out.println(list(head));
   }

   private String list(NodeDLL head) {

      if (nodeIsEmpty(head)) {
         return "empty list";
      }

      var builder = new StringBuilder();

      NodeDLL node = head;

      while (!nodeIsEmpty(node)) {

         builder.append(node.data);
         node = node.next;

         if(!nodeIsEmpty(node)){
            builder.append("<->");
         }

      }

      return builder.toString();

   }

   public boolean nodeIsEmpty(NodeDLL head){
      return head == null;
   }

   public int getData() {
      return data;
   }

   public NodeDLL getNext() {
      return next;
   }

   public void setNext(NodeDLL next) {
      this.next = next;
   }

   public NodeDLL getPrev() {
      return prev;
   }

   public void setPrev(NodeDLL prev) {
      this.prev = prev;
   }

}