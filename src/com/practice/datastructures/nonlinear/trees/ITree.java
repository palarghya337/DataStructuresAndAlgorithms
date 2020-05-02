package com.practice.datastructures.nonlinear.trees;

public interface ITree<T> {
	
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
	 * @param root
	 * @return Node<T>
	 */
	Node<T> insert(T element, Node<T> root);
	/**
	 * Method to get the head node of a tree.
	 * @return Node<T>
	 */
	Node<T> getRoot();
	/**
	 * Method to calculate the height of a tree.
	 * @return height
	 */
	int height();
	/**
	 * Method to return the level of a tree.
	 * @return level
	 */
	int level();
	/**
	 * This method will remove all the nodes of a tree.
	 */
	void removeAllNodes();
	/**
	 * This method will remove the specific node which is
	 * given in the parameter.
	 * 
	 * @param node
	 */
	void remove(Node<T> node);
	
	public static class Node<T> {
		
		public T element;
		public Node<T> left;
		public Node<T> right;
		public Node(T element) {
			this.element = element;
		}
	}
}
