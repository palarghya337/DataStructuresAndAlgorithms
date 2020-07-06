package com.practice.datastructures.linear.linkedlist;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class FindMiddleNode {

	public static void main(String[] args) {

		int maxSize = 7;
		Random random = new Random();
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		IntStream.generate(() -> random.nextInt(50))
			.distinct()
			.limit(maxSize)
			.forEach(data -> {
				linkedList.add(data);
				System.out.print(data + " ");
			});
		System.out.println();
		Node<?> middle = getMiddleNode(linkedList.getHeadNode());
		System.out.println("Middle Element: " + middle.element);
	}
	/**
	 * This method will find the middle Node of a linked list.
	 * @param headNode
	 * @return {@linkplain Node} middle node of a linked list.
	 */
	public static <T> Node<T> getMiddleNode(Node<T> headNode) {
		
		if (headNode != null) {
			
			Node<T> fastNode = headNode;
			Node<T> slowNode = headNode;
			while (fastNode != null && fastNode.next != null) {
				
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}
			return slowNode;
		}
		return headNode;
	}
}
