package com.maikella.datastructures.lineardatastructure.array;

import java.util.Arrays;
import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.inputs;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.out;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.toContinue;
import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;

public class Array {

   public static void main(String[] args) {

      var s = new Scanner(System.in);

      while(!out){

         if(toContinue != -1) {

            switch (menu(s)) {
               case 1:
                  search(s);
                  break;
               case 2:
                  add(s);
                  break;
               case 3:
                  remove(s);
                  break;

               default:
                  System.out.println("invalid value. just 1, 2 or 3");
            }
         }

         toContinue = out("do you want to continue? (y/n)", s);

         if(toContinue == -1){
            System.out.println("invalid value. just \"y\" for yes or \"n\" for no");
         }

      }
   }

   private static int menu(Scanner s){

      var sb = new StringBuffer();

      sb.append("your choice")
         .append("\n1 search")
         .append("\n2 add")
         .append("\n3 remove");

      int choice = checkInput(sb.toString(), s);

      return choice;
   }

   public static int size;
   private static int[] array = new int[5];

   private static void search(Scanner s){

      isEmpty(s);

      int key = checkInput("element you want to search: ", s);

      int index = binarySearch(array, 0, size-1, key);

      if(index > -1){
         System.out.println("found from index "+index);
      }else{
         System.out.println("element not found");
      }


   }

   private static int binarySearch(int[] array, int start, int end, int  key){

      if(end < start){
         return -1;
      }

      int mid = (start + end) / 2;

      if(key == array[mid]){
         return mid;
      }

      if(key > array[mid]){
         return binarySearch(array, ++mid, end, key);
      }

      return binarySearch(array, start, --mid, key);

   }

   private static void add(Scanner s){

      ensureCapacity();

      inputs = checkInput("number of elements you want to add: ", s);

      if(size == 0){
         array = new int[inputs];
      }


      try{
         for (int i = 0; i < inputs; i++) {

            array[size++] = checkInput("enter the "+(i+1)+"° element", s);

         }

      }catch (Exception e){

         System.out.println("limit reached");
      }

      print(array);
      System.out.println("added element");

   }

   private static void ensureCapacity(){

      if(inputs >= array.length){

         int[] newArray = new int [inputs];

         for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
         }

         array = newArray;
      }
   }

   private static void remove(Scanner s){

      isEmpty(s);

      int element = checkInput("remove an element", s);

      int index = binarySearch(array, 0, size-1, element);


      if(index == -1){
         System.out.println("element not found");
         return;
      }

      for (int i = index; i < array.length - 1; i++) {
         array[i] = array[i+1];

      }

      size--;

      createNewArray();

      System.out.println("element removed");
      print(array);
   }

   private static void createNewArray(){

      int[] newArray = new int [size];

      for (int i = 0; i < size; i++) {
         newArray[i] = array[i];
      }

      array = newArray;

   }


   protected static void print(int[] array){

      Arrays.sort(array);
      System.out.println(Arrays.toString(array));
   }

   private static void isEmpty(Scanner s){

      if(size == 0){
         System.out.println("array is empty");
         add(s);
      }
   }
}