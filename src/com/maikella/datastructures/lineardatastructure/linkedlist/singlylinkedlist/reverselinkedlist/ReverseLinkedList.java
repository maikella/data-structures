package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.reverselinkedlist;

import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.*;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;


public class ReverseLinkedList {

   private static class Node{

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
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

   private static Node reverse(Node head){

      Node prev = null, current = head, next = null;

      while(!isEmpty(current)){

         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }

      head = prev;
      return head;
   }

   private static String printList(Node head, String msg){

      if(isEmpty(head)){
         return "empty";
      }

      System.out.println(msg);

      Node aux = head;
      var sb = new StringBuffer();

      while(!isEmpty(aux)){

         sb.append(aux.data).append("->");
         aux = aux.next;

      }

      sb.append("NULL");

      return sb.toString();
   }

   public static void main(String[] args) {

      reverseLinkedList();

   }

   private static void reverseLinkedList(){

      var s = new Scanner(System.in);
      Node head = null;

      while(!out){

         inputs = checkInput("number of inputs", s);

         for (int i = 0; i < inputs; i++) {
            head = push(head, checkInput("enter the "+(1+i)+"° value", s));
         }

         System.out.println(printList(head, "given list"));

         head = reverse(head);

         System.out.println(printList(head, "reversed list"));

         out("do you want to continue? (y/n)", s);

         head = null;
      }
   }
}