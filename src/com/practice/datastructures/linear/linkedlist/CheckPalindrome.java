package com.practice.datastructures.linear.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class CheckPalindrome {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList =
				new SinglyLinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(1);
		System.out.println("isPalindrom: "
				+ isPalindromeSLL(linkedList.getHeadNode()));
	}
	public static <T> boolean isPalindromeSLL(Node<T> head) {
		
		if (head != null) {
			/*
			 * Here we are reversing the linked list
			 **/
			Node<T> current = head;
			Node<T> previous = null;
			while (current != null) {
				
				Node<T> next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			
			while (head != null) {
				if (!head.element.equals(previous.element)) {
					return false;
				}
				head = head.next;
			}
		}
		return true;
	}
	/**
	 * Method to check whether given singly linked list is
	 * palindrome or not.
	 * 
	 * @param <T>
	 * @param headNode
	 * @return isPalindrom
	 */
	public static <T> boolean isPalindrome(Node<T> headNode) {

		List<Node<T>> listOfNodes = new ArrayList<>();
		Node<T> current = headNode;
		while (current != null) {
			listOfNodes.add(current);
			current = current.next;
		}
		
		boolean isPalindrome = true;
		int i = 0;
		int j = listOfNodes.size() - 1;
		while (i < j) {
			if (!listOfNodes.get(i).element.equals(
					listOfNodes.get(j).element)) {
				isPalindrome = false;
				break;
			}
			i++;
			j--;
		}
		return isPalindrome;
	}
}
