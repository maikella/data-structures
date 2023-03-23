package com.maikella.datastructures.lineardatastructure.linkedlist.node;

import java.util.Scanner;

import static com.maikella.datastructures.utils.Utils.checkInput;

public class NodeSLL {

   private int data;
   private NodeSLL next, head;

   public NodeSLL() {}

   public NodeSLL(int data) {
      this.data = data;
   }

   public NodeSLL createLinkedList(int numInputs, Scanner scan) {

      return addElements(head, numInputs, scan);

   }

   public NodeSLL addElements(NodeSLL head, int numInputs, Scanner scan) {

      for (int i = 0; i < numInputs; i++) {
         head = push(checkInput("enter the " + (i + 1) + "° number", scan));
      }

      return head;
   }

   public NodeSLL push(int newData) {

      if (nodeIsEmpty(head)) {
         head = new NodeSLL(newData);
         return head;
      }

      var newNode = new NodeSLL(newData);

      newNode.next = head;
      head = newNode;

      return head;

   }

   public void displayList(NodeSLL head) {
      System.out.println(list(head));
   }

   private String list(NodeSLL head) {

      if (nodeIsEmpty(head)) {
         return "empty list";
      }

      var builder = new StringBuilder();

      NodeSLL node = head;

      while (!nodeIsEmpty(node)) {

         builder.append(node.data).append("->");
         node = node.next;

      }

      builder.append("NULL");

      return builder.toString();

   }

   public boolean nodeIsEmpty(NodeSLL head) {
      return head == null;
   }

   public int getData() {
      return data;
   }

   public void setData(int data) {
      this.data = data;
   }

   public NodeSLL getNext() {
      return next;
   }

   public void setNext(NodeSLL next) {
      this.next = next;
   }

   public NodeSLL getHead() {
      return head;
   }

   public void setHead(NodeSLL head) {
      this.head = head;
   }

}
