package com.practice.datastructures.linear;

public class SinglyLinkedList<E> {

	private int size;
	private Node<E> headNode;
	private Node<E> lastNode;
	
	public SinglyLinkedList() {
		// Default constructor
	}
	/**
	 * @param element
	 */
	public void insert(E element) {
		
		final Node<E> localNode = new Node<>(element, null);
		if (this.headNode == null) {
			this.headNode = localNode;
		} else {
			lastNode.next = localNode;
		}
		lastNode = localNode;
		size++;
	}
	/**
	 * @param index
	 * @return E
	 */
	public E get(int index) {
		
		if (index < size) {
			
			int count = 0;
			Node<E> localNode = headNode;
			while (count++ < index) {
				localNode = localNode.next;
			}
			return localNode.element;
		}
		return null;
	}
	public Node<E> getNode(int index) {
		
		int count = 1;
		Node<E> tempNode = headNode;
		while (count != index) {
			
			tempNode = tempNode.next;
			if (tempNode == null) {
				throw new RuntimeException("Node is not available.");
			}
			count++;
		}
		return tempNode;
	}
	/**
	 * @param element
	 * @return boolean
	 */
	public boolean remove(E element) {
		
		Node<E> prevNode = null;
		Node<E> currentNode = headNode;
		Node<E> nextNode = currentNode.next;
		boolean isElementAvailable = element.equals(currentNode.element);
		while (!isElementAvailable) {
			
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = currentNode.next;
			isElementAvailable = element.equals(currentNode.element);
		}
		if (prevNode == null) {
			headNode = nextNode;
		} else {
			prevNode.next = nextNode;//8374245387-chennareddy
			if (nextNode == null) {
				lastNode = prevNode;
			} else {
				currentNode.next = null;
			}
		}
		size--;
		return isElementAvailable;
	}
	/**
	 * Not fully implemented
	 * @param node
	 * @return
	 */
	public boolean remove(Node<E> node) {
		
		if (node != null) {
			
			Node<E> nextNode = node.next;
			if (nextNode != null) {
				
				node.element = nextNode.element;
				node.next = nextNode.next;
			}
		}
		return false;
	}
	public void reverse() {
		
		Node<E> currentNode = headNode;
		Node<E> nextNode = currentNode.next;
		Node<E> prevNode = null;
		while (nextNode != null) {
			
			Node<E> temp = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = currentNode.next;
			prevNode.next = temp;
		}
		currentNode.next = prevNode;
		headNode = currentNode;
	}
	public int size() {
		return size;
	}
	public static class Node<E> {
		
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	public Node<E> getHeadNode() {
		return headNode;
	}
	public void setHeadNode(Node<E> headNode) {
		this.headNode = headNode;
	}
}
