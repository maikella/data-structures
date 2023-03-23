package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

public class ReverseDLL {

   private final NodeDLL node;

   ReverseDLL(){
      node = new NodeDLL();
   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }

   private NodeDLL reverse(NodeDLL head){

     NodeDLL temp = null, current = head;

      while(!node.nodeIsEmpty(current)){

         temp = current.getPrev();
         current.setPrev(current.getNext());
         current.setNext(temp);
         current = current.getPrev();

      }

      if(!node.nodeIsEmpty(temp)){
         head = temp.getPrev();
      }

      return head;

   }

   public static void main(String[] args) {

      runReverseDLL();

   }

   private static void runReverseDLL(){

      try(var scan = new Scanner(System.in)){

         var reverseDLL = new ReverseDLL();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = reverseDLL.createLinkedList(numInputs, scan);

         System.out.println("original list");
         head.displayList(head);

         head = reverseDLL.reverse(head);

         System.out.println("the reversed list");
         head.displayList(head);

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}