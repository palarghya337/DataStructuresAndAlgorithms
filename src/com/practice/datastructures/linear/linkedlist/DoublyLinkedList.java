package com.practice.datastructures.linear.linkedlist;

public class DoublyLinkedList<E> {

	private int size; 
	private Node<E> node;
	private Node<E> lastNode;
	
	public void add(E data) {
		
		Node<E> newNode = new Node<>(data);
		if (node == null) {
			node = newNode;
		} else {
			newNode.previous = lastNode;
			lastNode.next = newNode;
		}
		lastNode = newNode;
		size++;
	}
	public E get(int index) {
		
		if (index < size) {
			
			boolean isLessThanhalf = index < size / 2;
			int count = isLessThanhalf ? 0 : size - 1;
			Node<E> localNode = isLessThanhalf ? node : lastNode;
			while (count != index) {
				
				if (isLessThanhalf) {
					localNode = localNode.next;
					count++;
				} else {
					localNode = localNode.previous;
					count--;
				}
			}
			return localNode.element;
		}
		return null;
	}
	private static class Node<E> {

		private E element;
		private Node<E> next;
		private Node<E> previous;
		
		public Node(E element) {
			this.element = element;
		}
	}
}
