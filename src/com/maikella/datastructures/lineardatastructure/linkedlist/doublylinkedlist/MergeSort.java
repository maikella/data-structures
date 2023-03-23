package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

public class MergeSort {

   private final NodeDLL node;

   MergeSort(){
      node = new NodeDLL();
   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }

   private NodeDLL split(NodeDLL head){

      NodeDLL fast = head, slow = head;

      while (!node.nodeIsEmpty(fast.getNext()) && !node.nodeIsEmpty(fast.getNext().getNext())){

         fast = fast.getNext().getNext();
         slow = slow.getNext();

      }

      NodeDLL temp = slow.getNext();
      slow.setNext(null);

      return temp;
   }

   private NodeDLL mergeSort(NodeDLL head){

      if(node.nodeIsEmpty(head) || node.nodeIsEmpty(head.getNext())){
         return head;
      }

      NodeDLL second = split(head);

      head = mergeSort(head);
      second = mergeSort(second);

      return merge(head, second);
   }

   private NodeDLL merge(NodeDLL first, NodeDLL second){

      if(node.nodeIsEmpty(first)){
         return second;
      }

      if(node.nodeIsEmpty(second)){
         return first;
      }

      if(first.getData() < second.getData()){

         first.setNext(merge(first.getNext(), second));
         first.getNext().setPrev(first);

         first.setPrev(null);

         return first;

      }else{

         second.setNext(merge(first, second.getNext()));
         second.getNext().setPrev(second);
         second.setPrev(null);

         return second;
      }
   }

   public static void main(String[] args) {

      runMergeSort();

   }

   private static void runMergeSort(){

      try(var scan = new Scanner(System.in)){

         var mergeSort = new MergeSort();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = mergeSort.createLinkedList(numInputs, scan);

         System.out.println("list before sorting");
         head.displayList(head);

         head = mergeSort.mergeSort(head);

         System.out.println("list after sorting");
         head.displayList(head);

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}