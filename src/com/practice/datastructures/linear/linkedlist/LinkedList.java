package com.practice.datastructures.linear.linkedlist;

public interface LinkedList<T> {

	/**
	 * Method to insert or add element in a linked list.
	 * This method call will create a new node every time
	 * and add the new element and point the current node
	 * to next of previous node.
	 * 
	 * @param element
	 */
	void add(T element);
	/**
	 * Method to remove all the nodes in a linked list.
	 * This method will reset the head node to null.
	 */
	void removeAll();
	/**
	 * Method to return the size of a linked list.
	 * @return size
	 */
	int size();
	/**
	 * Method to reverse the current linked list.
	 * It will also change the head node of a linked list.
	 */
	void reverse();
}
