package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.checkInput;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import static com.maikella.datastructures.utils.ErrorMessage.ELEMENT_NOT_EXIST;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class Search {

	private final NodeSLL node;

	public Search() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private boolean search(NodeSLL head, int value) {

		if (node.nodeIsEmpty(head)) {
			return false;
		}

		if (head.getData() == value) {
			return true;
		}

		return search(head.getNext(), value);

	}

	public static void main(String[] args) {

		runSearch();

	}

	private static void runSearch() {

		try (var scan = new Scanner(System.in)) {

			var search = new Search();

			int numInputs = getNumInputsFromUser(scan);

			NodeSLL head = search.createLinkedList(numInputs, scan);

			int searchElement = searchElement(scan);

			search.elementExists(head, searchElement);

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	private static int searchElement(Scanner scan) {

		return checkInput("element you want to search for:", scan);
	}

	private void elementExists(NodeSLL head, int searchElement) {

		boolean elementExists = search(head, searchElement);

		try {

			if (!elementExists) {
				throw new NoSuchElementException(ELEMENT_NOT_EXIST.getMessage());
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		if (elementExists) {
			System.out.println("the element " + searchElement + " exists");
		}
	}
}