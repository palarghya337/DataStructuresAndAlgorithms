package com.practice.datastructures.linear.linkedlist;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class RemoveNode {

	public static void main(String[] args) {
		
		int nodeIndexToRemove = 6;
		SinglyLinkedList<Integer> linkedList =
				getSinglyLinkedList();
		removeNode(linkedList.getNode(nodeIndexToRemove));
		System.out.println("\nAfter Removing "
				+ nodeIndexToRemove + "th Node: ");
		print(linkedList.getHeadNode());
	}
	/**
	 * Remove the respective nodes for a singly linked list
	 * which has the difference given in the 'difference'
	 * variable;
	 * 
	 * @param difference
	 * @param headNode
	 */
	public static void removeNodeHavingDifference(int difference,
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
	 * Method to remove given node from a linked list.
	 * @param Node
	 */
	public static <T> void removeNode(Node<T> node) {
		
		if (node != null) {
			
			Node<T> next = node.next;
			if (next != null) {
				
				node.element = next.element;
				node.next = next.next;
				next.next = null;
				next.element = null;
				next = null;
			} else {
				System.out.print("Can not remove the node as this is a last node.");
			}
		}
	}
	private static void print(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.element + " ");
			head = head.next;
		}
	}
	private static SinglyLinkedList<Integer> getSinglyLinkedList() {
		SinglyLinkedList<Integer> linkedList =
				new SinglyLinkedList<>();
		int limit = 7;
		Random random = new Random();
		IntStream.generate(() -> random.nextInt(50))
			.limit(limit)
			.forEach(element -> {
				linkedList.add(element);
				System.out.print(element + " ");
			});
		return linkedList;
	}
}
