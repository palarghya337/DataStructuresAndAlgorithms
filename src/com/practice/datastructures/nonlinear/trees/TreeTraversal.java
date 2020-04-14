package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.BinarySearchTree.Node;

public class TreeTraversal implements ITreeTraversal {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> inputTree =
				new InsertionBinarySearchTree<>();
		inputTree.insert(6);
		inputTree.insert(4);
		inputTree.insert(8);
		inputTree.insert(3);
		inputTree.insert(7);
		inputTree.insert(5);
		inputTree.insert(9);
		
		TreeTraversal traversal = new TreeTraversal();
		System.out.println("Pre Order Traversal: ");
		traversal.preOrderTraversal(inputTree.getHead());
		System.out.println("Post Order Traversal: ");
		traversal.postOrderTraversal(inputTree.getHead());
		System.out.println("InOrder Traversal: ");
		traversal.inOrderTraversal(inputTree.getHead());
	}

	@Override
	public <T extends Comparable<T>> void preOrderTraversal(Node<T> head) {
		if (head != null) {
			System.out.print(head.element + " ");
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
		}
	}

	@Override
	public <T extends Comparable<T>> void postOrderTraversal(Node<T> head) {
		
		if (head != null) {
			postOrderTraversal(head.left);
			postOrderTraversal(head.right);
			System.out.print(head.element + " ");
		}
	}

	@Override
	public <T extends Comparable<T>> void inOrderTraversal(Node<T> head) {

		if (head != null) {
			inOrderTraversal(head.left);
			System.out.print(head.element + " ");
			inOrderTraversal(head.right);
		}
	}
}
