package com.practice.datastructures.linear.linkedlist;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class LinkedListTest {

	private final static Random RANDOM = new Random();
	
	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		
		// check for palindrom
		testPalindromLinkedList(linkedList);
		// removing nodes
		removeSpecificElements(linkedList);
		// finding middle node
		showMiddleElement(linkedList);
		// sorting a linked list
		sort(linkedList);
		// remove duplicates from sorted linked list
		removeDuplicatesFromSortedLinkedList(linkedList);
	}
	private static void removeDuplicatesFromSortedLinkedList(SinglyLinkedList<Integer> linkedList) {
		
		linkedList.removeAll();
		linkedList.add(10);
		linkedList.add(10);
		linkedList.add(11);
		linkedList.add(12);
		linkedList.add(13);
		linkedList.add(13);
		linkedList.add(13);
		printList(linkedList.getHeadNode());
		Node<Integer> head = LinkedListUtil
				.removeDuplicatesFromSortedLinkedList(linkedList.getHeadNode());
		System.out.println("\nRemoved Duplicates: ");
		linkedList.setHeadNode(head);
		printList(head);
	}
	private static void sort(SinglyLinkedList<Integer> linkedList) {
		
		linkedList.removeAll();
		int maxSize = 10;
		IntStream.generate(() -> RANDOM.nextInt(50))
			.distinct()
			.limit(maxSize)
			.forEach(linkedList::add);
		printList(linkedList.getHeadNode());
		System.out.println("\nSorted Linked List: ");
		LinkedListUtil.sort(linkedList);
		printList(linkedList.getHeadNode());
	}
	private static void testPalindromLinkedList(SinglyLinkedList<Integer> linkedList) {
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(20);
		printList(linkedList.getHeadNode());
		boolean isPalindrom = LinkedListUtil
				.isPalindrome(linkedList.getHeadNode());
		System.out.println("\nisPalindrome: " + isPalindrom);
	}
	private static void removeSpecificElements(SinglyLinkedList<Integer> linkedList) {
		linkedList.removeAll();
		linkedList.add(10);
		linkedList.add(11);
		linkedList.add(13);
		linkedList.add(12);
		linkedList.add(15);
		linkedList.add(17);
		printList(linkedList.getHeadNode());
		LinkedListUtil.removeNode(2, linkedList);
		System.out.println("\nAfter removing specific elements: ");
		printList(linkedList.getHeadNode());
	}
	private static void showMiddleElement(SinglyLinkedList<Integer> linkedList) {
		linkedList.removeAll();
		int maxSize = 10;
		IntStream.generate(() -> RANDOM.nextInt(50))
			.distinct()
			.limit(maxSize)
			.forEach(linkedList::add);
		printList(linkedList.getHeadNode());
		System.out.println();
		Node<?> middle = LinkedListUtil
				.getMiddleNode(linkedList.getHeadNode());
		System.out.println("Middle Element: " + middle.element);
	}
	private static void printList(Node<Integer> headNode) {

		System.out.println("\n---------------");
		Node<Integer> tempNode = headNode;
		while (tempNode != null) {
			System.out.print(tempNode.element + " ");
			tempNode = tempNode.next;
		}
	}
}
