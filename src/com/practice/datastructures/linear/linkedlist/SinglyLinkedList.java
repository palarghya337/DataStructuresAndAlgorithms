package com.practice.datastructures.linear.linkedlist;

public class SinglyLinkedList<T> {

	private int size;
	private Node<T> head;
	private Node<T> lastNode;
	
	public SinglyLinkedList() {}
	/**
	 * Returns the element of a given index in a linked list.
	 * @param index
	 * @return E
	 */
	public T get(int index) {
		
		if (index < size) {
			
			int count = 0;
			Node<T> localNode = head;
			while (count++ < index) {
				localNode = localNode.next;
			}
			return localNode.element;
		}
		return null;
	}
	/**
	 * Returns the Node of a given index in the linked list.
	 * @param index
	 * @return Node
	 */
	public Node<T> getNode(int index) {
		
		int count = 1;
		Node<T> tempNode = head;
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
	 * Method to insert an element in a linked list.
	 * @param element
	 */
	public void add(T element) {
		
		final Node<T> localNode = new Node<>(element, null);
		if (this.head == null) {
			this.head = localNode;
		} else {
			lastNode.next = localNode;
		}
		lastNode = localNode;
		size++;
	}
	/**
	 * Method to remove all the elements in the linked list.
	 */
	public void removeAll() {
		
		Node<T> current = head;
		while (current != null) {
			
			Node<T> next = current.next;
			current.next = null;
			current = next;
			size--;
		}
		head = null;
	}
	/**
	 * Method to find and remove the node in a given parameter.
	 * If the node is available then it will remove the node
	 * otherwise it would not do anything.
	 * 
	 * @param node
	 * @return element
	 */
	public T remove(Node<T> node) {
		
		if (node == null) {
			throw new RuntimeException("Node can not be null");
		}
		T element = null;
		Node<T> previous = null;
		Node<T> current = head;
		while (current != null) {
			
			Node<T> next = current.next;
			if (current.element.equals(node.element)) {
				if (previous == null) {
					
					head = next;
					current.next = null;
				} else {
					previous.next = next;
					current.next = null;
				}
				element = node.element;
				size--;
				break;
			}
			current = next;
		}
		return element;
	}
	/*
	 * Returns the size of the linked list.
	 **/
	public int size() {
		return size;
	}
	/*
	 * Method will reverse the current linked list.
	 **/
	public void reverse() {
		
		Node<T> previous = null;
		Node<T> current = head;
		while (current != null) {
			// storing the next node into temporary variable.
			Node<T> next = current.next;
			// pointing current nodes next node to previous node
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	/**
	 * Returns the head node of current linked list.
	 * @return Node
	 */
	public Node<T> getHeadNode() {
		Node<T> duplicateHead = head;
		return duplicateHead;
	}
	/**
	 * Method to set the head node of current linked list.
	 * @param headNode
	 */
	public void setHeadNode(Node<T> headNode) {
		this.head = headNode;
	}
	public static class Node<T> {
		
		public Node<T> next;
		public T element;
		public Node(T element, Node<T> next) {
			
			this.element = element;
			this.next = next;
		}
	}
}
