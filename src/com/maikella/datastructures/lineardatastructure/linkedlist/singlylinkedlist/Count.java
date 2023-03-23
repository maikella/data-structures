package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import static com.maikella.datastructures.utils.ErrorMessage.ELEMENT_NOT_EXIST;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class Count {

	private final NodeSLL node;

	private int countValue = 0;

	public Count() {
		node = new NodeSLL();
	}

	private int count(NodeSLL head, int key) {

		if (node.nodeIsEmpty(head)) {
			return key;
		}

		if (head.getData() == key) {
			countValue++;
		}

		return count(head.getNext(), key);
	}

	public static void main(String[] args) {

		runCount();

	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private void countOccurrences(NodeSLL head, Scanner scan) {

		int key = checkInput("what number do you want to count?", scan);

		count(head, key);

		try {

			checkRepeatedElements(head, key);

		} catch (NoSuchElementException e) {
			System.out.println(ELEMENT_NOT_EXIST.getMessage());

		}

	}

	private void checkRepeatedElements(NodeSLL head, int key) {

		while (!node.nodeIsEmpty(head)) {

			if (head.getData() == key) {
				System.out.println("number " + key + ", repeated " + countValue);
				return;
			}

			head = head.getNext();
		}

		throw new NoSuchElementException();

	}

	private static void runCount() {

		try (var scan = new Scanner(System.in)) {

			var count = new Count();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = count.createLinkedList(numInputs, scan);

				head.displayList(head);

				count.countOccurrences(head, scan);

				isExiting = exit(scan);

				count.resetCounter();
			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private void resetCounter() {
		countValue = 0;
	}

}