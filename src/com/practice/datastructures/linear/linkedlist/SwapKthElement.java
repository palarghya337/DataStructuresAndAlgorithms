package com.practice.datastructures.linear.linkedlist;

import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class SwapKthElement {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		IntStream.range(1, 8).forEach(element -> {
			list.add(element);
			System.out.print(element + " ");
		});
		
		int k = 3;
		SwapKthElement obj = new SwapKthElement();
		obj.swapKthElementFromSinglyLinkedList(
				list.getHeadNode(), k);
		
		System.out.println("\nAfter Swapping k'th element: k = "
				+ k);
		print(list.getHeadNode());
	}
	/**
	 * Method to swap the k'th element from the start with the
	 * k'th element from the end of a linked list.
	 * @param <T>
	 * @param head
	 * @param k
	 */
	public <T> void swapKthElementFromSinglyLinkedList(
			Node<T> head, int k) {
		
		if (head != null) {
			
			int length = 0;
			Node<T> current = head;
			Node<T> kthFromStart = null;
			/*
			 * Below I am trying to find the k'th node from the
			 * starting of a singly linked list and as well as
			 * trying to find the size/length of the linked list. 
			 **/
			while (current != null) {
				if (length == k - 1) {
					kthFromStart = current;
				}
				length++;
				current = current.next;
			}
			int count = 0;
			current = head;
			/*
			 * Below I am trying to find the k'th node from the
			 * end of a linked list. Once I found the node then
			 * I will swap the elements of k'th node from start
			 * with the k'th node from the end.
			 **/
			while (current != null) {
				if (length - k == count) {
					
					T temp = current.element;
					current.element = kthFromStart.element;
					kthFromStart.element = temp;
					break;
				}
				count++;
				current = current.next;
			}
		}
	}
	private static void print(Node<Integer> headNode) {
		
		Node<Integer> current = headNode;
		while (current != null) {
			System.out.print(current.element + " ");
			current = current.next;
		}
	}
}
