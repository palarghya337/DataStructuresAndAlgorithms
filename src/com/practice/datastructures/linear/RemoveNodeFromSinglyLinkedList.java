package com.practice.datastructures.linear;

import com.practice.datastructures.linear.SinglyLinkedList.Node;

public class RemoveNodeFromSinglyLinkedList {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.insert(10);
		linkedList.insert(11);
		linkedList.insert(13);
		linkedList.insert(12);
		linkedList.insert(16);
		
		printList(linkedList.getHeadNode());
		removeNode(2, linkedList);
		printList(linkedList.getHeadNode());
	}
	private static void printList(Node<Integer> headNode) {
		
		System.out.println("\n---------------");
		Node<Integer> tempNode = headNode;
		while (tempNode != null) {
			System.out.print(tempNode.getElement() + " ");
			tempNode = tempNode.getNext();
		}
	}
	/**
	 * Remove the respective nodes which has the difference
	 * given in the 'difference' variable;
	 * 
	 * @param difference
	 * @param headNode
	 */
	public static void removeNode(int difference,
			SinglyLinkedList<Integer> linkedList) {

		Node<Integer> previousNode = null;
		Node<Integer> currentNode = linkedList.getHeadNode();
		while (currentNode != null) {
			
			int currentNodeElement = currentNode.getElement();
			Node<Integer> nextNode = currentNode.getNext();
			if (nextNode != null) {
				/*
				 * Need to check whether next node is null or not
				 * because we are going to see the difference
				 * between current node and next node.
				 **/
				int nextNodeElement = nextNode.getElement();
				if (Math.abs(currentNodeElement - nextNodeElement) == difference) {
					/*
					 * As we want to delete the nodes so we need
					 * to assign null to next.
					 **/
					currentNode.setNext(null);
					if (previousNode != null) {
						/*
						 * If current node is not the head node
						 * then we need to point the previous
						 * nodes next node to 2nd next of current
						 * node.
						 **/
						previousNode.setNext(nextNode.getNext());
						previousNode = currentNode;
						currentNode = nextNode;
					} else {
						/*
						 * If current node is the head node then
						 * we need to change the head node to
						 * 2nd next of current node.
						 **/
						currentNode = nextNode.getNext();
						linkedList.setHeadNode(currentNode);
					}
					nextNode.setNext(null);
				} else {
					/*
					 * If difference of two nodes does not match
					 * with the difference given in the variable
					 * "difference" then move forward.
					 **/
					previousNode = currentNode;
					currentNode = nextNode;
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
}
