package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

public class LinkedList <E>{

   private class Node{
       E item;
       Node next;

      public Node(E item) {
         this.item = item;
      }
   }

   private Node head;

   private void push(E item) {

      var newNode = new Node(item);

      newNode.next = head;
      head = newNode;

   }

   private boolean search(E key) {

      if(isEmpty()){
         return false;
      }

      if(head.item.equals(key)){
         return true;
      }

      head = head.next;

      return search(key);

   }

   private void delete(E key){

      Node temp = head, prev = null;

      if(!isEmpty() && temp.item.equals(key)){
         temp = temp.next;
      }

      while(!isEmpty() && !temp.item.equals(key)){
         prev = temp;
         temp = temp.next;
      }

      if(isEmpty()){
         return;
      }

      prev.next = temp.next;

   }

   private void addFirst(E element) {

      var newNode = new Node(element);

      if (isEmpty()) {
         head = newNode;
      } else {
         newNode.next = head;
         head = newNode;

      }
   }

   private void removeAll(){

      while(!isEmpty()){

         head.item = null;
         head = head.next;

      }
   }

   private int getSize(Node node, int size) {

      if(node == null){
         return size;
      }

      return getSize(node.next, ++size);
   }

   public boolean isEmpty() {
      return head == null;
   }

   public static boolean isEmpty(Object head){
      return head == null;
   }

   public boolean size(){
      return getSize(head, 0) == 0;
   }

   public void deleteList(){
      removeAll();
   }

   public void deleteElement(E key){
      delete(key);
   }

   public void addElement(E key){
      push(key);
   }

   public void addFirstElement(E key){
      addFirst(key);
   }

   public boolean searchList(E key){
      return search(key);
   }

   @Override public String toString() {

      if(isEmpty()){
         return "empty";
      }

      var sb = new StringBuffer();
      Node node = head;

      while(node != null){

         sb.append(node.item).append("->");
         node = node.next;

      }

      sb.append("NULL");

      return sb.toString();
   }
}