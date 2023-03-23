package com.maikella.datastructures.lineardatastructure.linkedlist.singlylinkedlist;

import static com.maikella.datastructures.utils.Utils.exit;
import static com.maikella.datastructures.utils.Utils.getNumInputsFromUser;

import java.util.Scanner;

import com.maikella.datastructures.lineardatastructure.linkedlist.node.NodeSLL;

public class QuickSort {

	private final NodeSLL node;

	public QuickSort() {
		node = new NodeSLL();
	}

	private NodeSLL createLinkedList(int numInputs, Scanner scan) {
		return node.createLinkedList(numInputs, scan);
	}

	private NodeSLL lastPartition(NodeSLL start, NodeSLL end) {

		if (start == end || node.nodeIsEmpty(start) || node.nodeIsEmpty(end)) {
			return start;
		}

		NodeSLL pivotPrev = start, current = start;

		int pivot = end.getData(), temp, aux;

		while (start != end) {

			if (start.getData() < pivot) {

				pivotPrev = current;
				temp = current.getData();
				current.setData(start.getData());
				start.setData(temp);
				current = current.getNext();

			}

			start = start.getNext();
		}

		aux = current.getData();
		current.setData(pivot);
		end.setData(aux);

		return pivotPrev;

	}

	private void sort(NodeSLL start, NodeSLL end) {

		if (node.nodeIsEmpty(start) || start == end || start == end.getNext()) {
			return;
		}

		NodeSLL pivotPrev = lastPartition(start, end);

		sort(start, pivotPrev);

		if (!node.nodeIsEmpty(pivotPrev) && pivotPrev == start) {

			sort(pivotPrev.getNext(), end);

		} else if (!node.nodeIsEmpty(pivotPrev)
			&& !node.nodeIsEmpty(pivotPrev.getNext())){

			sort(pivotPrev.getNext().getNext(), end);

		}

	}

	public static void main(String[] args) {

		runQuickSort();

	}

	private static void runQuickSort() {

		try (var scan = new Scanner(System.in)) {

			var quickSort = new QuickSort();

			boolean isExiting = false;
			int numInputs;

			NodeSLL head, node;

			while (!isExiting) {

				numInputs = getNumInputsFromUser(scan);

				head = quickSort.createLinkedList(numInputs, scan);

				System.out.println("list before sorting");
				head.displayList(head);

				node = head;

				while (!head.nodeIsEmpty(node.getNext())) {
					node = node.getNext();
				}

				quickSort.sort(head, node);

				System.out.println("list after sorting");
				head.displayList(head);

				isExiting = exit(scan);

			}

		} catch (Exception e) {

			System.out.println("error: " + e.getMessage());
			e.printStackTrace();

		}
	}
}