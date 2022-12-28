package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.search;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.readInformation;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;

import com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList;

import java.util.Scanner;

public class Search {

   public static void main(String[] args) {

      search();

   }

   private static void search(){

      var list = new LinkedList<String>();
      var s = new Scanner(System.in);

      while(!out){
         out = menu(list, s);
      }
   }

   private static boolean menu(LinkedList list, Scanner s){

      var sb = new StringBuffer();

      sb.append("1 add element\n")
         .append("2 add element in first\n")
         .append("3 search a element\n")
         .append("4 exit");

      int choice = checkInput(sb.toString(), s);

      if(choice != 4){

         if(choice == 3){
            searchElement(list, s);
            return false;
         }

         addElement(s, list, choice);

      }else{
         return true;
      }

      return false;

   }

   public static void addElement(Scanner s, LinkedList list, int choice){

      inputs = checkInput("number of inputs", s);

      for (int i = 0; i < inputs; i++) {

         switch (choice){
            case 1: list.addElement(readInformation("enter the "+(i+1)+"° value", s));
               break;
            case 2: list.addFirstElement(readInformation("enter the "+(i+1)+"° value", s));
         }

      }

      System.out.println(list);

   }

   public static void searchElement(LinkedList list, Scanner s){

      if(isEmpty(list)){
         return;
      }

      String key = readInformation("search a value", s);

      boolean isPresent = list.searchList(key);

      if(isPresent){
         System.out.println(key+", is present in the list");
      }else{
         System.out.println(key+", not present in the list");
      }

   }

   public static boolean isEmpty(LinkedList list){

      if(list.size()){
         System.out.println("the list is empty, add an element");
         return true;
      }

      return false;
   }

}