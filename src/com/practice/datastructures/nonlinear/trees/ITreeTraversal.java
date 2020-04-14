package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.BinarySearchTree.Node;

public interface ITreeTraversal {

	public <T extends Comparable<T>> void preOrderTraversal(Node<T> head);
	public <T extends Comparable<T>> void postOrderTraversal(Node<T> head);
	public <T extends Comparable<T>> void inOrderTraversal(Node<T> head);
}
