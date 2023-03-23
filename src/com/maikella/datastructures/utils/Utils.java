package com.maikella.datastructures.utils;

import static com.maikella.datastructures.utils.ErrorMessage.NEGATIVE_NUMBER;
import static com.maikella.datastructures.utils.ErrorMessage.ONLY_NUMBERS;
import static com.maikella.datastructures.utils.ErrorMessage.ONLY_YES_OR_NO;


import java.util.Scanner;

public final class Utils {

	private Utils() {};

	private static final String GET_NUM_INPUTS = "how many values do you want to add?";
	private static final String EXIT = "do you want to continue? (y/n)";

	public static int getNumInputsFromUser(Scanner scan) {
		return checkNumInputsFromUser(GET_NUM_INPUTS, scan);
	}

	private static int checkNumInputsFromUser(String msg, Scanner scan) {

		int input;

		while (true) {

			try {

				input = checkInput(msg, scan);

				if (input <= 0) {
					throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
				}

				break;

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
		return input;
	}

	public static int checkInput(String msg, Scanner scan) {

		int input;

		while (true) {

			try {

				input = Integer.parseInt(readInformation(msg, scan));
				break;

			} catch (NumberFormatException e) {
				System.out.println(ONLY_NUMBERS.getMessage());
			}

		}

		return input;

	}

	private static String readInformation(String msg, Scanner scan) {

		System.out.println(msg);

      return scan.nextLine();
	}

	public static boolean exit(Scanner scan) {

		String input;

		while (true) {

			System.out.println(EXIT);

			input = scan.nextLine().toLowerCase();

			if (input.equals("y")) {
				return false;
			} else if (input.equals("n")) {
				return true;
			} else {
				System.out.println(ONLY_YES_OR_NO.getMessage());
			}
		}
	}
}