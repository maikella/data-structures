package com.maikella.datastructures.utils;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;
import static com.maikella.datastructures.utils.Utils.checkInput;

import java.util.Arrays;
import java.util.Scanner;

public final class ArrayUtils {

	private ArrayUtils(){}

	public static void printArray(int[] array) {

		System.out.println(Arrays.toString(array));

	}

	public static void printArraySorted(int[] array) {

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

	}

	public static int[] createArray(Scanner scan) {

		int numInputs = getNumInputsFromUser(scan);

		int[] array = new int[numInputs];

		for (int i = 0; i < array.length; i++) {

			array[i] = addElementsToArray(i, scan);

		}

		return array;
	}

	public static int addElementsToArray(int index, Scanner scan) {

		return checkInput("enter the " + (index + 1) + "° number", scan);

	}

	public static boolean arrayIsEmpty(int[] array) {

		return array.length == 0;
	}

}
