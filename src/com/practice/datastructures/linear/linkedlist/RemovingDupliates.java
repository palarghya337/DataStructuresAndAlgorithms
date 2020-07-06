package com.practice.datastructures.linear.linkedlist;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class RemovingDupliates {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = 
				new SinglyLinkedList<>();
		linkedList.add(10);
		linkedList.add(10);
		linkedList.add(11);
		linkedList.add(12);
		linkedList.add(13);
		linkedList.add(13);
		linkedList.add(13);
		printList(linkedList.getHeadNode());
		Node<Integer> head = removeDuplicatesFromSortedLinkedList(
				linkedList.getHeadNode());
		System.out.println("\nRemoved Duplicates: ");
		linkedList.setHeadNode(head);
		printList(head);
	}
	/**
	 * Removes the duplicate elements from the sorted linked list
	 * 
	 * @param <T>
	 * @param head
	 * @return headNode in case duplicate element is present
	 * in the first node then changes the head node otherwise
	 * head node remains same.
	 */
	public static <T> Node<T> removeDuplicatesFromSortedLinkedList(Node<T> head) {
		
		Node<T> previous = null;
		Node<T> current = head;
		while (current != null) {
			
			Node<T> next = current.next;
			T currentElement = current.element;
			if (next != null && currentElement
					.equals(next.element)) {
				
				if (previous == null) {
					head = next;
				} else {
					previous.next = next;
				}
				current.next = null;
			} else {
				previous = current;
			}
			current = next;
		}
		return head;
	}
	private static void printList(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.element + " ");
			head = head.next;
		}
	}
}
