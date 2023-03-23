package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

public class FindPairsWithGivenSum {

   private final NodeDLL node;

   FindPairsWithGivenSum(){
      node = new NodeDLL();
   }

   private void pairSum(NodeDLL head, int key){

      NodeDLL first = head, second = head;

      while(!node.nodeIsEmpty(second.getNext())){
         second = second.getNext();
      }

      boolean foundPair = false;
      var builder = new StringBuilder();

      while(first != second && second.getNext() != first){

         if((first.getData() + second.getData()) == key){

            foundPair = true;

            builder.append("(")
               .append(first.getData())
               .append(",")
               .append(second.getData())
               .append(")");

            first = first.getNext();
            second = second.getPrev();

         } else{

            if((first.getData() + second.getData()) < key){
               first = first.getNext();
            }else{
               second = second.getPrev();
            }
         }
      }

      if(!foundPair){
         System.out.println("no pair found");
      }else{
         System.out.println(builder);
      }

   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }

   public static void main(String[] args) {

      runFindPairsWithGivenSum();

   }

   private static void runFindPairsWithGivenSum(){

      try(var scan = new Scanner(System.in)){

         var findPairsWithGivenSum = new FindPairsWithGivenSum();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = findPairsWithGivenSum.createLinkedList(numInputs, scan);

         head.displayList(head);
         int key = checkInput("enter a number to find its sum", scan);

         System.out.println("pairs whose sum is " + key);
         findPairsWithGivenSum.pairSum(head, key);

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}