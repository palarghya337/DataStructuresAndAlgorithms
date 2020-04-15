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
		traversal.bfsTraversal(headNode);
		System.out.print("\nDFS Traversal: ");
		traversal.dfsTraversal(headNode);
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
	
	public <T extends Comparable<T>> void bfsTraversal(Node<T> head) {
		// TODO: need to implement it properly
		int height = BinarySearchTreeUtil.height(head);
		if (head != null) {
			
			Node<T> left = head.left;
			Node<T> right = head. right;
//			print(head);
			print(left);
			print(right);
			bfsTraversal(left);
			bfsTraversal(right);
		}
	}

	private <T extends Comparable<T>> void print(Node<T> node) {
		if (node != null) {
			System.out.print(node.element + " ");
		}
	}
	public <T extends Comparable<T>> void dfsTraversal(Node<T> head) {
		
		preOrderTraversal(head);
	}
}
