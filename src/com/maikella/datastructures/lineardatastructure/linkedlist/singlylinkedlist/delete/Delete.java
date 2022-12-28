package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.delete;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.readInformation;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;

import com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.LinkedList;

import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.search.Search.isEmpty;
import static com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist.search.Search.addElement;

import java.util.Scanner;

public class Delete{

   public static void main(String[] args) {

      delete();

   }

   private static void delete(){

      var list = new LinkedList<String>();
      var s = new Scanner(System.in);

      while(!out){

         menu(list, s);

      }
   }

   private static void menu(LinkedList list, Scanner s){

      var sb = new StringBuffer();

      sb.append("1 add element\n")
         .append("2 add element in first\n")
         .append("3 delete element\n")
         .append("4 delete list\n")
         .append("5 exit");

      int choice = checkInput(sb.toString(), s);

      switch(choice){
         case 1: addElement(s, list, choice);
            break;
         case 2: addElement(s, list, choice);
            break;
         case 3: deleteElement(list, s);
            break;
         case 4: deleteList(list);
            break;
         case 5: out = true;
      }

   }

   private static void deleteElement(LinkedList list, Scanner s){

      if(isEmpty(list)){
         return;
      }

      String key = readInformation("enter delete value", s);

      list.deleteElement(key);

      System.out.println(list);

   }

   private static void deleteList(LinkedList list){

      if(isEmpty(list)){
         return;
      }

      list.deleteList();
      System.out.println("list deleted");
   }
}