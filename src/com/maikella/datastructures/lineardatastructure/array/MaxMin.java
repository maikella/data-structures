package com.maikella.datastructures.lineardatastructure.array;

import static com.maikella.datastructures.utils.ArrayUtils.createArray;
import static com.maikella.datastructures.utils.ArrayUtils.printArray;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {

		runMaxMin();

	}

	private static void runMaxMin() {

		try (var scan = new Scanner(System.in)) {

			int[] array = createArray(scan);

			printArray(array);

			int min = findMin(array, array.length);
			int max = findMax(array, array.length);

			System.out.println("max value " + max);
			System.out.println("min value " + min);

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private static int findMin(int[] array, int length) {

		if (length == 1) {
			return array[0];
		}

		return Math.min(array[length - 1], findMin(array, length - 1));
	}

	private static int findMax(int[] array, int length) {

		if (length == 1) {
			return array[0];
		}

		return Math.max(array[length - 1], findMax(array, length - 1));
	}
}