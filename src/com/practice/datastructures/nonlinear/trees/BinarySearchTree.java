package com.practice.datastructures.nonlinear.trees;

public abstract class BinarySearchTree<T extends Comparable<T>> {
	
	public abstract void insert(T element);
	public abstract Node<T> getHead();
	
	protected static class Node<T extends Comparable<T>> {
		
		protected T element;
		protected Node<T> left;
		protected Node<T> right;
		protected Node(T element) {
			this.element = element;
		}
	}
}
