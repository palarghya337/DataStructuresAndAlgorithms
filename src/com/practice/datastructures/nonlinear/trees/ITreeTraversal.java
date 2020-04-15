package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.ITree.Node;

public interface ITreeTraversal {

	<T extends Comparable<T>> void preOrderTraversal(Node<T> head);
	<T extends Comparable<T>> void postOrderTraversal(Node<T> head);
	<T extends Comparable<T>> void inOrderTraversal(Node<T> head);
	<T extends Comparable<T>> void levelOrderTraversal(Node<T> head);
	<T extends Comparable<T>> void dfsTraversal(Node<T> head);
	<T extends Comparable<T>> void spiralOrderTraversal(Node<T> head);
	<T extends Comparable<T>> void reverseLevelOrderTraversal(Node<T> head);
}
