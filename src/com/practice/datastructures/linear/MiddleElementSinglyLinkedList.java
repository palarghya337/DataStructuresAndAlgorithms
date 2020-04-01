package com.practice.datastructures.linear;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.SinglyLinkedList.Node;

public class MiddleElementSinglyLinkedList {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		int maxSize = 10;
		Random random = new Random();
		IntStream.generate(() -> random.nextInt(50))
		.distinct()
		.limit(maxSize)
		.forEach(linkedList::insert);
		printList(linkedList.getHeadNode());
		Node<Integer> middle = getMiddleNode(linkedList.getHeadNode());
		System.out.println("\n---------------");
		System.out.println("Middle Element: " + middle.getElement());
	}
	/**
	 * This method will find the middle Node of a linked list.
	 * @param headNode
	 * @return
	 */
	private static Node<Integer> getMiddleNode(Node<Integer> headNode) {
		
		Node<Integer> fastNode = headNode;
		Node<Integer> slowNode = headNode;
		if (headNode != null) {
			
			while (fastNode != null && fastNode.getNext() != null) {
				
				fastNode = fastNode.getNext().getNext();
				slowNode = slowNode.getNext();
			}
		}
		return slowNode;
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
