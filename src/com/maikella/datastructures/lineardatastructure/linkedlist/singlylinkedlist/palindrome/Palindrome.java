package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.palindrome;

import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.*;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList.isEmpty;

public class Palindrome {

   Node head;
   Node left;

   private class Node {

      char data;
      Node next;

      public Node(char data) {
         this.data = data;
      }
   }

   private boolean checkPalindrome(Node right) {

      left = head;

      if (isEmpty(right)) {
         return true;
      }

      boolean check = checkPalindrome(right.next);

      if (check == false) {
         return false;
      }

      boolean isPalindrome = right.data == left.data;

      left = left.next;

      return isPalindrome;
   }

   private boolean isPalindrome(Node head) {

      boolean result = checkPalindrome(head);
      return result;
   }

   private void push(char newData) {

      if(isEmpty(head)){

         head = new Node(newData);
         return;

      }

      var newNode = new Node(newData);
      newNode.next = head;
      head = newNode;
   }

   public static void main(String[] args) {

      startPalindrome();

   }

   private static void startPalindrome() {

      var s = new Scanner(System.in);
      var list = new Palindrome();

      String input;
      char[] str;

      while(!out){

         input = readInformation("enter the value", s);
         str = new char[input.length()];

         for (int i = 0; i < input.length(); i++) {

            str[i] = input.charAt(i);
            list.push(str[i]);

         }

         if (list.isPalindrome(list.head)) {
            System.out.println(input+", is palindrome");
         } else {
            System.out.println(input+", not palindrome");
         }

         out("do you want to continue? (y/n)", s);

         list.head = null;
      }
   }
}