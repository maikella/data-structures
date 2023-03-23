package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class ReverseLinkedList {

	private final NodeSLL node;

	public ReverseLinkedList() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private NodeSLL reverse(NodeSLL head) {

		NodeSLL prev = null, current = head, next;

		while (!node.nodeIsEmpty(current)) {

			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		head = prev;

		return head;
	}

	public static void main(String[] args) {

		reverseLinkedList();

	}

	private static void reverseLinkedList() {

		try (var scan = new Scanner(System.in)) {

			var reverseLinkedList = new ReverseLinkedList();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = reverseLinkedList.createLinkedList(numInputs, scan);

				System.out.println("given list");
				head.displayList(head);

				head = reverseLinkedList.reverse(head);

				System.out.println("reversed list");
				head.displayList(head);

				isExiting = exit(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}