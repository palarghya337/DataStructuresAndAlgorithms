package com.practice.datastructures.linear.linkedlist;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class Reversing {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		int maxSize = 10;
		Random random = new Random();
		
		IntStream.generate(() -> random.nextInt(50))
		.distinct()
		.limit(maxSize)
		.forEach(linkedList::insert);
		
		printList(linkedList.getHeadNode());
		reverseLinkedList(linkedList);
		printList(linkedList.getHeadNode());
	}
	/**
	 * Reversing the elements of a linked list.
	 * @param linkedList
	 */
	private static void reverseLinkedList(SinglyLinkedList<Integer> linkedList) {
		
		if (linkedList != null) {
			
			Node<Integer> currentNode = linkedList.getHeadNode();
			Node<Integer> previousNode = null;
			while (currentNode != null) {
				// storing the next node into temporary variable.
				Node<Integer> tempNode = currentNode.getNext();
				// pointing current nodes next node to previous node
				currentNode.setNext(previousNode);
				previousNode = currentNode;
				currentNode = tempNode;
			}
			linkedList.setHeadNode(previousNode);
		}
	}
	private static void printList(Node<Integer> headNode) {

		System.out.println("\n---------------");
		Node<Integer> tempNode = headNode;
		while (tempNode != null) {
			System.out.print(tempNode.getElement() + " ");
			tempNode = tempNode.getNext();
		}
	}
}
