package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class PairwiseSwap {

	private final NodeSLL node;

	public PairwiseSwap() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private void pairwiseSwap(NodeSLL head) {

		NodeSLL aux = head;
		int temp;

		while (!node.nodeIsEmpty(aux) && !node.nodeIsEmpty(aux.getNext())) {

			temp = aux.getData();
			aux.setData(aux.getNext().getData());
			aux.getNext().setData(temp);
			aux = aux.getNext().getNext();
		}

		node.displayList(head);
	}

	public static void main(String[] args) {

		runPairwiseSwap();

	}

	private static void runPairwiseSwap() {

		try (var scan = new Scanner(System.in)) {

			var pairwiseSwap = new PairwiseSwap();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = pairwiseSwap.createLinkedList(numInputs, scan);

				System.out.println("list before calling pairwiseSwap()");
				head.displayList(head);

				System.out.println("list after calling pairwiseSwap()");
				pairwiseSwap.pairwiseSwap(head);

				isExiting = exit(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}