package com.maikella.datastructures.lineardatastructure.array;

import static com.maikella.datastructures.utils.Utils.exit;

import static com.maikella.datastructures.utils.ArrayUtils.createArray;
import static com.maikella.datastructures.utils.ArrayUtils.printArray;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {

		runReverse();

	}

	private static void runReverse() {

		try (var scan = new Scanner(System.in)) {

			boolean isExiting = false;

			while (!isExiting) {
				getArrayReverse(scan);
				isExiting = exit(scan);
			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private static void getArrayReverse(Scanner scan) {

		int[] array = createArray(scan);

		System.out.println("given array");
		printArray(array);

		reverse(array, 0, array.length - 1);

		System.out.println("reverse array");
		printArray(array);

	}

	private static void reverse(int[] array, int start, int end) {

		int temp;

		if (start >= end) {
			return;
		}

		temp = array[start];
		array[start] = array[end];
		array[end] = temp;

		reverse(array, ++start, --end);

	}
}