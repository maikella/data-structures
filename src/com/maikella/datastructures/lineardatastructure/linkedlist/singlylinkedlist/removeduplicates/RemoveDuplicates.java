package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.removeduplicates;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicates {

   private static class Node{

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   private static void removeDuplicates(Node head){

      var list = new HashMap<Integer, Boolean>();
      Node aux = head;

      System.out.println("list after duplicate removal");

      while(!isEmpty(aux)){

         if(!list.containsKey(aux.data)){

            System.out.print(aux.data+"->");

         }

         list.put(aux.data, true);
         aux = aux.next;
      }

      System.out.println("NULL");



   }

   private static String printList(String msg, Node head){

      Node node = head;

      if(isEmpty(node)){
         return "empty";
      }

      System.out.println(msg);

      var sb = new StringBuffer();

      while (!isEmpty(node)){

         sb.append(node.data).append("->");
         node = node.next;

      }

      sb.append("NULL");

      return sb.toString();
   }

   private static Node push(Node head, int newData){

      if(isEmpty(head)){
         head = new Node(newData);
         return head;
      }

      var newNode = new Node(newData);
      newNode.next = head;
      head = newNode;

      return head;
   }

   public static void main(String[] args) {

      startRemoveDuplicates();

   }

   private static void startRemoveDuplicates(){

      var s = new Scanner(System.in);
      Node head = null;

      while(!out){

         inputs = checkInput("number of inputs ", s);

         for (int i = 0; i < inputs; i++) {
            head = push(head, checkInput("enter the "+(1+i)+"° value", s));
         }

         System.out.println(printList("list before duplicate removal", head));

         removeDuplicates(head);

         out("do want to continue? (y/n)", s);

         head = null;

      }
   }
}