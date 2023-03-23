package com.maikella.datastructures.lineardatastructure.array;

import static com.maikella.datastructures.utils.ArrayUtils.createArray;
import static com.maikella.datastructures.utils.ArrayUtils.printArraySorted;

import java.util.Scanner;

public class Merge {

	public static void main(String[] args) {

		runMerge();

	}

	private static void runMerge() {

		try (var scan = new Scanner(System.in)) {

			int[] array1, array2, array3;

			System.out.println("1° array");
			array1 = createArray(scan);

			System.out.println("2° array");
			array2 = createArray(scan);

			array3 = new int[array1.length + array2.length];

			mergeArrays(array1, array2, array3, array1.length, array2.length);

			System.out.println("after merging");
			printArraySorted(array3);

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private static void mergeArrays(int[] array1, int[] array2, int[] array3, int size1, int size2) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < size1) {
			array3[k++] = array1[i++];
		}

		while (j < size2) {
			array3[k++] = array2[j++];
		}
	}
}