package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import java.util.Scanner;

import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

public class CountTripletsInList {

   private final NodeDLL node;
   CountTripletsInList(){
      node = new NodeDLL();
   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }
   private int countPairs(NodeDLL first, NodeDLL second, int key){

      int count = 0;

      while(!node.nodeIsEmpty(first) && !node.nodeIsEmpty(second) &&
         first != second && second.getNext() != first){

         if((first.getData() + second.getData() == key)){

            count++;

            first = first.getNext();
            second = second.getPrev();

         }else if((first.getData() + second.getData() > key)){
            second = second.getPrev();
         }else{
            first = first.getNext();
         }
      }

      return count;
   }

   private int countTriplets(NodeDLL head, int key){

      if(node.nodeIsEmpty(head)){
         return 0;
      }

      NodeDLL current, first, last = head;

      int count = 0;

      while(!node.nodeIsEmpty(last.getNext())){
         last = last.getNext();
      }

      for (current = head; !node.nodeIsEmpty(current) ; current = current.getNext()) {

         first = current.getNext();

         count += countPairs(first, last, key - current.getData());

      }

      return count;
   }

   public static void main(String[] args) {

      runCountTripletsInList();

   }

   private static void runCountTripletsInList(){

      try(var scan = new Scanner(System.in)) {

         var countTripletsInList = new CountTripletsInList();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = countTripletsInList.createLinkedList(numInputs, scan);

         head.displayList(head);

         int key = checkInput("enter a number to find its sum", scan);
         System.out.println("count of triplets in this list: "+ countTripletsInList.countTriplets(head, key));

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}