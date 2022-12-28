package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.quicksort;

import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;


public class QuickSort {

   private static class Node{

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }


   private static Node push(Node head, int data){

      if(isEmpty(head)){

         head = new Node(data);
         return head;

      }

      Node current = head;

      while(!isEmpty(current.next)){
         current = current.next;
      }

      var newNode = new Node(data);
      current.next = newNode;

      return head;
   }

   private static String printList(Node head){

      if(isEmpty(head)){
         return "empty";
      }

      var sb = new StringBuffer();

      while (!isEmpty(head)){

         sb.append(head.data).append("->");
         head = head.next;
      }

      sb.append("NULL");

      return sb.toString();

   }

   private static Node lastPartition(Node start, Node end){

      if(start == end || isEmpty(start) || isEmpty(end)){
         return start;
      }

      Node pivotPrev = start;
      Node current = start;
      int pivot = end.data;
      int temp, aux;

      while(start != end){

         if(start.data < pivot){

            pivotPrev = current;
            temp = current.data;
            current.data = start.data;
            start.data = temp;
            current = current.next;

         }

         start = start.next;
      }

      aux = current.data;
      current.data = pivot;
      end.data = aux;

      return pivotPrev;

   }

   public static void sort(Node start, Node end){

      if(isEmpty(start) || start == end || start == end.next){
         return;
      }

      Node pivotPrev = lastPartition(start, end);
      sort(start, pivotPrev);

      if(!isEmpty(pivotPrev) && pivotPrev == start){
         sort(pivotPrev.next, end);
      } else if (!isEmpty(pivotPrev) && !isEmpty(pivotPrev.next)) {
         sort(pivotPrev.next.next, end);
      }


   }

   public static void main(String[] args) {

      var s = new Scanner(System.in);
      Node head = null;

      while(!out){

         inputs = checkInput("number of inputs", s);

         for (int i = 0; i < inputs; i++) {
            head = push(head, checkInput("enter the "+(1+i)+"° value", s));
         }

         System.out.println("list before sorting");
         System.out.println(printList(head));

         Node node = head;

         while (!isEmpty(node.next)){
            node = node.next;
         }

         sort(head, node);

         System.out.println("list after sorting");
         System.out.println(printList(head));

         out("do you want to continue? (y/n)", s);

         head = null;

      }
   }
}
