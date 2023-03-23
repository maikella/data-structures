package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class DeleteMiddle {

	private final NodeSLL node;

	public DeleteMiddle() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private int countOfNodes(NodeSLL head) {

		int count = 0;

		while (!node.nodeIsEmpty(head)) {

			head = head.getNext();
			count++;
		}

		return count;

	}

	private void deleteMid(NodeSLL head) {

		if (node.nodeIsEmpty(head) || node.nodeIsEmpty(head.getNext())) {
			return;
		}

		int count = countOfNodes(head);
		int mid = count / 2;

		while (mid-- > 1) {
			head = head.getNext();
		}

		head.setNext(head.getNext().getNext());

	}

	public static void main(String[] args) {

		runDeleteMiddle();

	}

	private static void runDeleteMiddle() {

		try (var scan = new Scanner(System.in)) {

			var deleteMiddle = new DeleteMiddle();

			int numInputs = getNumInputsFromUser(scan);

			NodeSLL head = deleteMiddle.createLinkedList(numInputs, scan);

			System.out.println("given list");
			head.displayList(head);

			deleteMiddle.deleteMid(head);

			System.out.println("list after deletion of middle");
			head.displayList(head);

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}