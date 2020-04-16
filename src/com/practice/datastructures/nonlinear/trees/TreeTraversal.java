package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.ITree.Node;

public class TreeTraversal implements ITreeTraversal {

	public static void main(String[] args) {
		
		ITree<Integer> inputTree =
				new BinarySearchTree<Integer>();
		inputTree.insert(6);
		inputTree.insert(4);
		inputTree.insert(8);
		inputTree.insert(3);
		inputTree.insert(7);
		inputTree.insert(5);
		inputTree.insert(9);
		Node<Integer> headNode = inputTree.getHead();
		
		TreeTraversal traversal = new TreeTraversal();
		System.out.print("Pre Order Traversal: ");
		traversal.preOrderTraversal(headNode);
		System.out.print("\nPost Order Traversal: ");
		traversal.postOrderTraversal(headNode);
		System.out.print("\nInOrder Traversal: ");
		traversal.inOrderTraversal(headNode);
		System.out.print("\nBFS Traversal: ");
		traversal.levelOrderTraversal(headNode);
		System.out.print("\nDFS Traversal: ");
		traversal.dfsTraversal(headNode);
	}

	@Override
	public <T> void preOrderTraversal(Node<T> head) {
		if (head != null) {
			System.out.print(head.element + " ");
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
		}
	}

	@Override
	public <T> void postOrderTraversal(Node<T> head) {
		
		if (head != null) {
			postOrderTraversal(head.left);
			postOrderTraversal(head.right);
			System.out.print(head.element + " ");
		}
	}

	@Override
	public <T> void inOrderTraversal(Node<T> head) {

		if (head != null) {
			inOrderTraversal(head.left);
			System.out.print(head.element + " ");
			inOrderTraversal(head.right);
		}
	}
	@Override
	public <T> void levelOrderTraversal(Node<T> head) {
		
		int height = BinarySearchTreeUtil.height(head);
		for (int i = 1; i <= height; i++) {
			levelOrderTraversal(head, i);
		}
	}

	private <T> void levelOrderTraversal(Node<T> head, int level) {
		
		if (head != null) {
			if (level == 1) {
				System.out.print(head.element + " ");
			} else {
				levelOrderTraversal(head.left, level - 1);
				levelOrderTraversal(head.right, level - 1);
			}
		}
	}
	@Override
	public <T> void dfsTraversal(Node<T> head) {
		
		preOrderTraversal(head);
	}

	@Override
	public <T> void spiralOrderTraversal(Node<T> head) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void reverseLevelOrderTraversal(Node<T> head) {
		// TODO Auto-generated method stub
		
	}
}
