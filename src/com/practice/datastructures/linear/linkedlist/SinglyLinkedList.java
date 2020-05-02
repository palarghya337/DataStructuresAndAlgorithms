package com.practice.datastructures.linear.linkedlist;

public class SinglyLinkedList<T> implements LinkedList<T> {

	private volatile int size;
	private Node<T> head;
	private Node<T> lastNode;
	
	public SinglyLinkedList() {
		super();
	}
	/**
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
	
	@Override
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
	@Override
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
			throw new RuntimeException("Removing node can not be null");
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
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
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
	public Node<T> getHeadNode() {
		return head;
	}
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
