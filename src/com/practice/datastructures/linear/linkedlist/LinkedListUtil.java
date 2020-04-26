package com.practice.datastructures.linear.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class LinkedListUtil {

	private LinkedListUtil() {
		super();
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
	/**
	 * Remove the respective nodes for a singly linked list
	 * which has the difference given in the 'difference'
	 * variable;
	 * 
	 * @param difference
	 * @param headNode
	 */
	public static void removeNode(int difference,
			SinglyLinkedList<Integer> linkedList) {

		Node<Integer> previous = null;
		Node<Integer> current = linkedList.getHeadNode();
		while (current != null) {
			
			int currentNodeElement = current.element;
			Node<Integer> nextNode = current.next;
			if (nextNode != null) {
				/*
				 * Need to check whether next node is null or not
				 * because we are going to see the difference
				 * between current node and next node.
				 **/
				int nextNodeElement = nextNode.element;
				if (Math.abs(currentNodeElement - nextNodeElement) == difference) {
					/*
					 * As we want to delete the nodes so we need
					 * to assign null to next.
					 **/
					current.next = null;
					if (previous != null) {
						/*
						 * If current node is not the head node
						 * then we need to point the previous
						 * nodes next node to 2nd next of current
						 * node.
						 **/
						previous.next = nextNode.next;
					} else {
						/*
						 * If current node is the head node then
						 * we need to change the head node to
						 * 2nd next of current node.
						 **/
						linkedList.setHeadNode(nextNode.next);
					}
					current = nextNode.next;
					nextNode.next = null;
				} else {
					/*
					 * If difference of two nodes does not match
					 * with the difference given in the variable
					 * "difference" then move forward.
					 **/
					previous = current;
					current = nextNode;
				}
			} else {
				/*
				 * If there is no next node available then stop
				 * checking for difference. 
				 **/
				break;
			}
		}
	}
	/**
	 * Method to find the size of a singly Linked List.
	 * @param <T>
	 * @param headNode
	 * @return size
	 */
	public static <T> int getSizeOfSinglyLinkedList(Node<T> headNode) {
		
		Node<T> currentNode = headNode;
		int size = 0;
		while (currentNode != null) {
			
			currentNode = currentNode.next;
			size++;
		}
		return size;
	}
	/**
	 * This method will find the middle Node of a linked list.
	 * @param headNode
	 * @return
	 */
	public static <T> Node<T> getMiddleNode(Node<T> headNode) {
		
		Node<T> fastNode = headNode;
		Node<T> slowNode = headNode;
		if (headNode != null) {
			
			while (fastNode != null && fastNode.next != null) {
				
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}
		}
		return slowNode;
	}
	/**
	 * Method to sort a singly linked list;
	 * @param <T>
	 * @param linkedList
	 */
	public static <T extends Comparable<T>> void sort(SinglyLinkedList<T> linkedList) {
		
		Node<T> current = linkedList.getHeadNode();
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
}
