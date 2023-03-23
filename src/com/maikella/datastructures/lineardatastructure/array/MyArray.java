package com.maikella.datastructures.lineardatastructure.array;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.maikella.datastructures.utils.ArrayUtils.printArraySorted;
import static com.maikella.datastructures.utils.ArrayUtils.addElementsToArray;
import static com.maikella.datastructures.utils.ArrayUtils.arrayIsEmpty;

import static com.maikella.datastructures.utils.ErrorMessage.ELEMENT_NOT_EXIST;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;
import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.exit;

public class MyArray {

	private static final String MENU_ERROR_MESSAGE = "error: invalid value! only 1, 2, or 3 are allowed";
	private static final int SEARCH = 1, REMOVE = 2, EXIT = 3;
	private static final int MIN_CHOICE = 1, MAX_CHOICE = 3;
	private static int numElements;
	private static boolean isExitingMenu = false;
	private static int[] array;

	public static void main(String[] args) {

		runMyArray();

	}

	private static void runMyArray() {

		try (var scan = new Scanner(System.in)) {

			createArrayAndAddElements(scan);

			int menuChoice;

			while (!isExitingMenu) {

				menuChoice = showMenuAndGetChoice(scan);
				handleMenuChoice(menuChoice, scan);
				isExitingMenu(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private static void isExitingMenu(Scanner scan) {

		if (!isExitingMenu) {
			exit(scan);
		}

	}

	private static void handleMenuChoice(int menuChoice, Scanner scan) {

		switch (menuChoice) {
			case SEARCH:
				search(scan);
				break;
			case REMOVE:
				remove(scan);
				break;
			case EXIT:
				System.exit(0);
		}

	}

	private static int showMenuAndGetChoice(Scanner scan) {

		var builder = new StringBuilder();

		builder.append("what do you want to do?")
			.append("\n1 search")
			.append("\n2 remove")
			.append("\n3 exit");

		return checkAndGetChoice(builder.toString(), scan);

	}

	private static int checkAndGetChoice(String msg, Scanner scan) {

		int menuChoice;

		while (true) {

			try {

				menuChoice = getChoice(msg, scan);

				break;

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}

		return menuChoice;

	}

	private static int getChoice(String msg, Scanner scan){

		int getChoice = checkInput(msg, scan);

		if (getChoice < MIN_CHOICE || getChoice > MAX_CHOICE) {
			throw new IllegalArgumentException(MENU_ERROR_MESSAGE);
		}

		return getChoice;
	}

	private static void search(Scanner scan) {

		int key = checkInput("element you want to search for:", scan);

		int index = binarySearch(array, 0, array.length - 1, key);

		elementExists(index);

	}

	private static int binarySearch(int[] array, int start, int end, int key) {

		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (key == array[mid]) {
			return mid;
		}

		if (key > array[mid]) {
			return binarySearch(array, ++mid, end, key);
		}

		return binarySearch(array, start, --mid, key);

	}

	private static void createArrayAndAddElements(Scanner scan) {

		array = new int[getNumInputsFromUser(scan)];

		for (int i = 0; i < array.length; i++) {

			array[numElements++] = addElementsToArray(i, scan);

		}

		printArraySorted(array);

	}

	private static void remove(Scanner scan) {

		int element, index, elementExists = -1;

		while (elementExists == -1) {

			element = checkInput("which element do you want to delete?", scan);

			index = binarySearch(array, 0, numElements - 1, element);

			elementExists = elementExists(index);

			if (elementExists > -1) {

				for (int i = index; i < array.length - 1; i++) {
					array[i] = array[i + 1];

				}

				numElements--;

				updateArray(numElements);

				System.out.println("element removed");

				if (!checkAndAddIfEmpty()) {

					printArraySorted(array);

				} else {

					isExitingMenu = true;

				}

			}

		}

	}

	private static void updateArray(int numElements) {

		int[] newArray = new int[numElements];

		for (int i = 0; i < numElements; i++) {
			newArray[i] = array[i];
		}

		array = newArray;

	}

	private static boolean checkAndAddIfEmpty() {

		if (arrayIsEmpty(array)) {

			System.out.println("the array is empty");

			return true;

		}

		return false;

	}

	private static int elementExists(int index) {

		try {

			if (index == -1) {
				throw new NoSuchElementException(ELEMENT_NOT_EXIST.getMessage());
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		if (index > -1) {
			System.out.println("found in index " + index);
		}

		return index;
	}
}