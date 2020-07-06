package com.practice.datastructures.linear.linkedlist;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class SortingOfLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList =
				new SinglyLinkedList<>();
		Random random = new Random();
		int maxSize = 10;
		IntStream.generate(() -> random.nextInt(50))
			.distinct()
			.limit(maxSize)
			.forEach(data -> {
				linkedList.add(data);
				System.out.print(data+ " ");
			});
		System.out.println("\nSorted Linked List: ");
		sort(linkedList.getHeadNode());
		print(linkedList.getHeadNode());
	}
	private static void print(Node<Integer> head) {
		while (head != null) {
			
			System.out.print(head.element + " ");
			head = head.next;
		}
	}
	/**
	 * Method to sort a singly linked list in O(n^2) time.
	 * @param <T>
	 * @param linkedList
	 */
	public static <T extends Comparable<T>> void sort(
			Node<T> head) {
		
		Node<T> current = head;
		while (current != null) {
			
			Node<T> next = current.next;
			while (next != null) {
				if (current.element.compareTo(next.element) == 1) {
					
					T temp = current.element;
					current.element = next.element;
					next.element = temp;
				}
				next = next.next;
			}
			current = current.next;
		}
	}
}
