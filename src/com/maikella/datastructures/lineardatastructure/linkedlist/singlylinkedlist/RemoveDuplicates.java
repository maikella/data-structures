package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class RemoveDuplicates {

	private final NodeSLL node;

	public RemoveDuplicates() {
		node = new NodeSLL();
	}

	private void removeDuplicates(NodeSLL head) {

		Map<Integer, Boolean> list = new HashMap<>();
		NodeSLL aux = head;

		System.out.println("list after duplicates have been removed");

		while (!node.nodeIsEmpty(aux)) {

			if (!list.containsKey(aux.getData())) {

				System.out.print(aux.getData() + "->");

			}

			list.put(aux.getData(), true);
			aux = aux.getNext();
		}

		System.out.println("NULL");

	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	public static void main(String[] args) {

		runRemoveDuplicates();

	}

	private static void runRemoveDuplicates() {

		try (var scan = new Scanner(System.in)) {

			var removeDuplicates = new RemoveDuplicates();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = removeDuplicates.createLinkedList(numInputs, scan);

				System.out.println("list before duplicates are removed");
				head.displayList(head);

				removeDuplicates.removeDuplicates(head);

				isExiting = exit(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}