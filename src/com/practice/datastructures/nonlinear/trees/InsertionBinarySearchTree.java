package com.practice.datastructures.nonlinear.trees;

public class InsertionBinarySearchTree<T extends Comparable<T>>
	extends BinarySearchTree<T> {
	
	protected Node<T> head;
	
	public void insert(T element) {
		if (head == null) {
			head = new Node<>(element);
		} else {
			head = insert(element, head);
		}
	}
	public Node<T> insert(T element, Node<T> localHead) {
		
		if (localHead != null) {
			if (element.compareTo(localHead.element) < 1 ) {
				
				localHead.left = insert(element, localHead.left);
			} else {
				localHead.right = insert(element, localHead.right);
			}
			return localHead;
		}
		return new Node<>(element);
	}
	public Node<T> getHead() {
		return head;
	}
}
