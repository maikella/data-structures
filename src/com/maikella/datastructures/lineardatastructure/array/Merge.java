package com.maikella.datastructures.lineardatastructure.array;

import java.util.Scanner;

import static com.maikella.datastructures.lineardatastructure.array.Reverse.checkInput;

public class Merge {

   public static void main(String[] args) {

      int[] array1, array2, array3;

      System.out.println("1° array");
      array1 = createArray();

      System.out.println("2° array");
      array2 = createArray();

      array3 = new int[array1.length + array2.length];

      mergeArrays(array1, array2, array3, array1.length, array2.length);

      System.out.println("after merging");
      Array.print(array3);

   }

   protected static int[] createArray(){

      var s = new Scanner(System.in);

      int sizeArray = checkInput("number of entries array: ", s);
      int[] array = new int[sizeArray];

      for (int i = 0; i < sizeArray; i++) {

         array[i] = checkInput("enter the "+(i+1)+"° number", s);

      }

      Array.print(array);

      return array;
   }

   private static void mergeArrays(int[] array1, int[] array2, int[] array3, int size1, int size2){

      int i = 0;
      int j = 0;
      int k = 0;

      while (i < size1){
         array3[k++] = array1[i++];
      }

      while (j < size2){
         array3[k++] = array2[j++];
      }
   }
}
