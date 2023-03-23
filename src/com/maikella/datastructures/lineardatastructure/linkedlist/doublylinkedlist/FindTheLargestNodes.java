package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

public class FindTheLargestNodes {

   private final NodeDLL node;

   FindTheLargestNodes(){
      node = new NodeDLL();
   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }

   private int largestInDLL(NodeDLL head){

      NodeDLL temp = head, max = head;

      while(!node.nodeIsEmpty(temp)){


         if(temp.getData() > max.getData()){
            max = temp;
         }else{
            temp = temp.getNext();
         }
      }

      return max.getData();
   }

   public static void main(String[] args) {

      runFindTheLargestNodes();

   }

   private static void runFindTheLargestNodes(){

      try(var scan = new Scanner(System.in)){

         var findTheLargestNodes = new FindTheLargestNodes();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = findTheLargestNodes.createLinkedList(numInputs, scan);

         head.displayList(head);

         int max = findTheLargestNodes.largestInDLL(head);

         System.out.println("the largest node in the list is " + max);

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}