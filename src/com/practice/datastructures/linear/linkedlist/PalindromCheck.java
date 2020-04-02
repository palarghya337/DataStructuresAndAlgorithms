package com.practice.datastructures.linear.linkedlist;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class PalindromCheck {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(10);
		
		printList(linkedList.getHeadNode());
		boolean isPalindrom = isPalindrom(linkedList.getHeadNode());
		System.out.println(isPalindrom);
	}
	private static boolean isPalindrom(Node<Integer> headNode) {

		StringBuilder numbers = new StringBuilder();
		Node<Integer> currentNode = headNode;
		while (currentNode != null) {
			numbers.append(currentNode.getElement() + ",");
			currentNode = currentNode.getNext();
		}
		String numberArr[] = numbers.toString().split(",");
		boolean isPalindrom = true;
		int i = 0;
		int j = numberArr.length - 1;
		while (i < j) {
			if (!numberArr[i].equals(numberArr[j])) {
				isPalindrom = false;
				break;
			}
			i++;
			j--;
		}
		return isPalindrom;
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
