package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.pairwiseswap;

import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;

public class PairwiseSwap {

   private class Node{

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   static Node head;

   private void push(int newData){

      if (isEmpty(head)) {
         head = new Node(newData);
         return;
      }

      var newNode = new Node(newData);
      newNode.next = head;
      head = newNode;

   }

   private String printList(String msg){

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

   private static void pairwiseSwap(){

      Node aux = head;
      int temp;

      while(!isEmpty(aux) && !isEmpty(aux.next)){

         temp = aux.data;
         aux.data = aux.next.data;
         aux.next.data = temp;
         aux = aux.next.next;
      }

   }

   public static void main(String[] args) {

      startPairwiseSwap();

   }

   private static void startPairwiseSwap(){

      var list = new PairwiseSwap();
      var s = new Scanner(System.in);

      while(!out){

         inputs = checkInput("number of inputs", s);

         for (int i = 0; i < inputs; i++) {

            list.push(checkInput("enter the "+(1+i)+"° value", s));
            
         }

         System.out.println(list.printList("list before calling pairwiseSwap()"));

         pairwiseSwap();

         System.out.println(list.printList("list after calling pairwiseSwap()"));

         out("do you want to continue? (y/n)", s);

         head = null;

      }
   }
}