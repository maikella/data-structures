package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.count;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;

import java.util.Scanner;

public class Count {

   public static class Node {

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }

   }

   public static Node push(Node head, int newData){

      var newNode = new Node(newData);

      newNode.next = head;
      head = newNode;

      return head;

   }

   private static int countValue = 0;

   private static int count(Node head, int key){

      if(isEmpty(head)){
         return key;
      }

      if(head.data == key){
         countValue++;
      }

      return count(head.next, key);
   }

   private static String printList(Node head){

      if(isEmpty(head)){
         return "empty";
      }

      var sb = new StringBuffer();
      Node node = head;

      while (!isEmpty(node)){

         sb.append(node.data).append("->");
         node = node.next;
      }

      sb.append("NULL");

      return sb.toString();

   }

   public static void main(String[] args) {

      var s = new Scanner(System.in);
      Node head = null;

      while(!out){

         inputs = checkInput("number of inputs", s);

         for (int i = 0; i < inputs; i++) {
            head = push(head, checkInput("enter the "+(i+1)+"° value", s));
         }

         System.out.println(printList(head));

         int key = checkInput("count number", s);

         count(head, key);

         System.out.println("count of "+key+" is " + countValue);

         out("do you want to continue? (y/n)", s);

         countValue = 0;
      }
   }
}