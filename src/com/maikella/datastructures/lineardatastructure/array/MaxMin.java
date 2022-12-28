package com.maikella.datastructures.lineardatastructure.array;

import static com.maikella.datastructures.lineardatastructure.array.Merge.createArray;

public class MaxMin {

   public static void main(String[] args) {

      int[] array = createArray();

      int min = findMin(array, array.length);
      int max = findMax(array, array.length);

      System.out.println("max value "+max);
      System.out.println("min value "+min);

   }

   private static int findMin(int[] array, int length){

      if(length == 1){
         return array[0];
      }

      return Math.min(array[length-1], findMin(array, length-1));
   }

   private static int findMax(int[] array, int length){

      if(length == 1){
         return array[0];
      }

      return Math.max(array[length-1], findMax(array, length-1));
   }
}