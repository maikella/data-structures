package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.segregate;

import com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;

import java.util.Scanner;

public class Segregate extends LinkedList{

   Node head;

   public class Node{

      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   private void segregateEvenOdd(){

      Node evenStart = null;
      Node evenEnd = null;
      Node oddStart = null;
      Node oddEnd = null;
      Node current = head;

      while(!isEmpty(current)){

         int element = current.data;

         if(element % 2 == 0){

            if(isEmpty(evenStart)){
               evenStart = current;
               evenEnd = evenStart;
            }else{
               evenEnd.next = current;
               evenEnd = evenEnd.next;

            }

         }else{

            if(isEmpty(oddStart)){
               oddStart = current;
               oddEnd = oddStart;
            }else{
               oddEnd.next = current;
               oddEnd = oddEnd.next;
            }

         }

         current = current.next;
      }

      if(isEmpty(evenStart) || isEmpty(oddStart)){
         return;
      }

      evenEnd.next = oddStart;
      oddEnd.next = null;
      head = evenStart;

   }

   private void push(int newData){

      var newNode = new Node(newData);

      newNode.next = head;
      head = newNode;

   }

   private String printList(){

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
      var list = new Segregate();

      inputs = checkInput("number of inputs", s);

      for (int i = 0; i < inputs; i++) {

        list.push(checkInput("enter the "+(1+i)+"° value", s));

      }

      if(!list.printList().equals("empty")){

         System.out.println("original list");
         System.out.println(list.printList());

         list.segregateEvenOdd();

         System.out.println("modified list");
         System.out.println(list.printList());
      }

   }
}