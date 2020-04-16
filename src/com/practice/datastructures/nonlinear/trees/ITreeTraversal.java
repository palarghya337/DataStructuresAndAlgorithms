package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.ITree.Node;

public interface ITreeTraversal {

	<T> void preOrderTraversal(Node<T> head);
	<T> void postOrderTraversal(Node<T> head);
	<T> void inOrderTraversal(Node<T> head);
	<T> void levelOrderTraversal(Node<T> head);
	<T> void dfsTraversal(Node<T> head);
	<T> void spiralOrderTraversal(Node<T> head);
	<T> void reverseLevelOrderTraversal(Node<T> head);
}
