package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class Segregate {

	private final NodeSLL node;

	public Segregate() {
		node = new NodeSLL();
	}

	private void segregateEvenOdd() {

		NodeSLL evenStart = null, evenEnd = null, oddStart = null;
		NodeSLL oddEnd = null, current = node.getHead();

		while (!node.nodeIsEmpty(current)) {

			int element = current.getData();

			if (element % 2 == 0) {

				if (node.nodeIsEmpty(evenStart)) {

					evenStart = current;
					evenEnd = evenStart;

				} else {

					evenEnd.setNext(current);
					evenEnd = evenEnd.getNext();

				}

			} else {

				if (node.nodeIsEmpty(oddStart)) {

					oddStart = current;
					oddEnd = oddStart;

				} else {

					oddEnd.setNext(current);
					oddEnd = oddEnd.getNext();

				}

			}

			current = current.getNext();
		}

		if (node.nodeIsEmpty(evenStart) || node.nodeIsEmpty(oddStart)) {
			return;
		}

		evenEnd.setNext(oddStart);
		oddEnd.setNext(null);
		node.setHead(evenStart);

	}

	private void createLinkedList(int numINputs, Scanner scan) {
		node.setHead(node.createLinkedList(numINputs, scan));
	}

	private void getListSegregate() {

		boolean nodeIsEmpty = node.nodeIsEmpty(node.getHead());

		if (!nodeIsEmpty) {

			System.out.println("original list");
			node.displayList(node.getHead());

			segregateEvenOdd();

			System.out.println("modified list");
			node.displayList(node.getHead());

		}

	}

	public static void main(String[] args) {

		runSegregate();

	}

	private static void runSegregate() {

		try (var scan = new Scanner(System.in)) {

			var segregate = new Segregate();

			int numInputs = getNumInputsFromUser(scan);

			segregate.createLinkedList(numInputs, scan);

			segregate.getListSegregate();

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}