package com.maikella.datastructures.lineardatastructure.linkedlist.doublylinkedlist;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeDLL;

import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

public class DeleteAllOccurrencesOfKey {

   private final NodeDLL node;

   DeleteAllOccurrencesOfKey(){
      node = new NodeDLL();
   }

   private NodeDLL createLinkedList(int numInputs, Scanner scan){
      return node.createLinkedList(numInputs, scan);
   }
   private NodeDLL deleteNode(NodeDLL head, NodeDLL delete){

      if(node.nodeIsEmpty(head) || node.nodeIsEmpty(delete)){
         return head;
      }

      if(head == delete){
         head = delete.getNext();
      }

      if(!node.nodeIsEmpty(delete.getNext())){
         delete.getNext().setPrev(delete.getPrev());
      }

      if(!node.nodeIsEmpty(delete.getPrev())){
         delete.getPrev().setNext(delete.getNext());
      }

      delete = null;

      return head;

   }

   private NodeDLL deleteAllOccurrencesOfKey(NodeDLL head, int key){

      if(node.nodeIsEmpty(head)){
         return head;
      }

      NodeDLL current = head, next;

      while(!node.nodeIsEmpty(current)){

         if(current.getData() == key){

            next = current.getNext();
            head = deleteNode(head, current);
            current = next;

         }else{
            current = current.getNext();
         }

      }

      return head;
   }

   public static void main(String[] args) {

      runDeleteAllOccurrencesOfKey();

   }

   private static void runDeleteAllOccurrencesOfKey(){

      try(var scan = new Scanner(System.in)){

         var deleteAllOccurrencesOfKey = new DeleteAllOccurrencesOfKey();

         int numInputs = getNumInputsFromUser(scan);

         NodeDLL head = deleteAllOccurrencesOfKey.createLinkedList(numInputs, scan);

         head.displayList(head);

         int key = checkInput("which number do you want to delete?", scan);

         head = deleteAllOccurrencesOfKey.deleteAllOccurrencesOfKey(head, key);

         System.out.println("list after deletion of " + key);
         head.displayList(head);

      } catch (Exception e) {

         System.out.println("error: " + e.getMessage());
         e.printStackTrace();

      }
   }
}