package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class MoveFront {

	private final NodeSLL node;

	public MoveFront() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private NodeSLL moveToFront(NodeSLL head) {

		if (node.nodeIsEmpty(head) || node.nodeIsEmpty(head.getNext())) {
			return head;
		}

		NodeSLL secLast = null, last = head;

		while (!node.nodeIsEmpty(last.getNext())) {
			secLast = last;
			last = last.getNext();
		}

		secLast.setNext(null);
		last.setNext(head);

		head = last;

		return head;
	}

	public static void main(String[] args) {

		runMoveFront();

	}

	private static void runMoveFront() {

		try (var scan = new Scanner(System.in)) {

			var moveFront = new MoveFront();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = moveFront.createLinkedList(numInputs, scan);

				System.out.println("list before moving the last to the front");
				head.displayList(head);

				head = moveFront.moveToFront(head);

				System.out.println("list after moving the last to the front");
				head.displayList(head);

				isExiting = exit(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}