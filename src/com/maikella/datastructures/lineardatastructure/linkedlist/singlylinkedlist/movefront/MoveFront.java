package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.movefront;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;

import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;

import java.util.Scanner;

public class MoveFront {

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

   private static String printList(Node node, String msg){

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

   private static Node moveToFront(Node head){

      if(isEmpty(head) || isEmpty(head.next)){
         return head;
      }

      Node secLast = null;
      Node last = head;

      while(!isEmpty(last.next)){
         secLast = last;
         last = last.next;
      }

      secLast.next = null;
      last.next = head;

      head = last;

      return head;
   }

   public static void main(String[] args) {

      var s = new Scanner(System.in);
      Node head = null;

      System.out.println(printList(head, "test"));

      while (!out){

         inputs = checkInput("number of inputs", s);

         for (int i = 0; i < inputs; i++) {
            head = push(head, checkInput("enter the "+(1+i)+"° value", s));
         }

         System.out.println(printList(head, "list before moving last to front"));

         Node newHead = head;
         head = moveToFront(newHead);

         System.out.println(printList(head, "list after moving last to front"));

         out("do you want to continue? (y/n)", s);

         head = null;

      }
   }
}
