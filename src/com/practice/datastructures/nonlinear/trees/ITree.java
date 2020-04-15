package com.practice.datastructures.nonlinear.trees;

public interface ITree<T extends Comparable<T>> {
	
	/**
	 * Method to insert data in a tree.
	 * @param element
	 */
	void insert(T element);
	
	/**
	 * This method will insert the element in a specific position
	 * under given head node and will return the updated head node.
	 * 
	 * @param element
	 * @param head
	 * @return Node<T>
	 */
	Node<T> insert(T element, Node<T> head);
	/**
	 * Method to get the head node of a tree.
	 * @return Node<T>
	 */
	Node<T> getHead();
	/**
	 * Method to calculate the height of a tree.
	 * @return height
	 */
	int height();
	/**
	 * This method will remove all the nodes of a tree.
	 */
	void removeAllNodes();
	
	public static class Node<T extends Comparable<T>> {
		
		protected T element;
		protected Node<T> left;
		protected Node<T> right;
		protected Node(T element) {
			this.element = element;
		}
	}
}
