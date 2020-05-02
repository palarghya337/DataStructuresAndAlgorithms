package com.practice.datastructures.linear;

import java.util.Objects;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList;
import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class LinkedQueue<T> implements Queue<T> {

	private int size;
	private SinglyLinkedList<T> linkedList;
	
	public LinkedQueue() {
		linkedList = new SinglyLinkedList<T>();
	}
	
	@Override
	public void add(T element) {
		linkedList.add(element);
		size++;
	}
	/**
	 * @throws NullPointerException
	 */
	@Override
	public T remove() {
		Node<T> head = linkedList.getHeadNode();
		Objects.requireNonNull(head);
		size--;
		return linkedList.remove(head);
	}
	@Override
	public T poll() {
		Node<T> head = linkedList.getHeadNode();
		if (head == null) {
			return null;
		}
		size--;
		return linkedList.remove(head);
	}
	@Override
	public T peek() {
		
		Node<T> head = linkedList.getHeadNode();
		Objects.requireNonNull(head);
		return head.element;
	}
	@Override
	public int size() {
		return size;
	}
}
