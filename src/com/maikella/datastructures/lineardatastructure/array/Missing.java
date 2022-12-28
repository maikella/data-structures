package com.maikella.datastructures.lineardatastructure.array;

import static com.maikella.datastructures.lineardatastructure.array.Merge.createArray;

public class Missing {

   public static void main(String[] args) {

      int[] array = createArray();
      int missing = findMissing(array, array.length);
      System.out.println("the missing number is "+missing);

   }

   private static int findMissing(int[] array, int length){

      int[] temp = new int[length+1];

      for (int i = 0; i < length; i++) {
         temp[array[i] - 1] = 1;
      }

      int missing = 0;

      for (int i = 0;  i <= length; i++) {
         if(temp[i] == 0){
            missing = i+1;
         }
      }
      return missing;
   }
}