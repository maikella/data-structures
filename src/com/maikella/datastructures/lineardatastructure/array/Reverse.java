package com.maikella.datastructures.lineardatastructure.array;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse {

   public static boolean out = false;
   public static int inputs;
   protected static int toContinue;

   public static void main(String[] args) {

      var s = new Scanner(System.in);

      while(!out) {

         if(toContinue != -1){
            start(s);
         }

         toContinue = out("do you want to continue? (y/n)", s);

         if(toContinue == -1){
            System.out.println("invalid value. just \"y\" for yes or \"n\" for no");
         }
      }
   }

   private static void start(Scanner s){

      inputs = checkInput("number of entries: ", s);

      int[] array = new int[inputs];

      for (int i = 0; i < array.length; i++) {

         array[i] = checkInput("enter the "+(i+1)+"° number", s);

      }

      System.out.println("given array");
      System.out.println(Arrays.toString(array));

      reverse(array, 0, array.length - 1);

      System.out.println("reverse array");
      System.out.println(Arrays.toString(array));

   }

   public static int checkInput(String msg, Scanner s){

      boolean out = false;
      int index = 0;

      while (!out){

         try{

            index = Integer.parseInt(readInformation(msg, s));
            out = true;

         }catch (Exception e){

            System.out.println("invalid value");

         }
      }

      return index;
   }

   public static int out(String msg, Scanner s){

      System.out.println(msg);
      String input = s.nextLine().toLowerCase();

      if(input.equals("y") || input.equals("n")){

         if (input.equals("n")){
            out = true;
         }

         return 0;
      }

      return -1;
   }

   private static void reverse(int[] array, int start, int end){

      int temp;

      if(start >= end) {
         return;
      }

      temp = array[start];
      array[start] = array[end];
      array[end] = temp;

      reverse(array, ++start, --end);

   }


   public static String readInformation(String msg, Scanner s){

      System.out.println(msg);
      String input = s.nextLine();

      return input;
   }

}