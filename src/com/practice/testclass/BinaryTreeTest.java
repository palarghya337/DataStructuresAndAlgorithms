package com.practice.testclass;

import java.util.stream.IntStream;

import com.practice.datastructures.nonlinear.trees.BinaryTree;
import com.practice.datastructures.nonlinear.trees.BinaryTreeUtils;
import com.practice.datastructures.nonlinear.trees.ITree.Node;
import com.practice.datastructures.nonlinear.trees.TreeTraversal;

public class BinaryTreeTest {

	public static void main(String[] args) {
		/*
		isIdentical();
		
		findCommonManager();
		
		findNextNode();
		*/
		convertBTtoDLL();
	}

	private static void convertBTtoDLL() {
		
		BinaryTree<Integer> firstTree = new BinaryTree<>();
		IntStream.range(1, 10)
		.forEach(firstTree::insert);
		Node<Integer> head = BinaryTreeUtils
				.getDoublyLinkedList(
						firstTree.getRoot());
		while (head != null) {
			
			StringBuilder b = new StringBuilder();
			b.append(head.element);
			b.append("(");
			if (head.left == null) {
				b.append("-");
			} else {
				b.append(head.left.element);
			}
			b.append(") ");
			System.out.print(b);
			head = head.right;
		}
	}

	private static void findNextNode() {
		
		BinaryTree<Integer> firstTree = new BinaryTree<>();
		IntStream.range(1, 10)
		.forEach(firstTree::insert);
		
		Node<Integer> nodeToFind = new Node<Integer>(4);
		nodeToFind = BinaryTreeUtils
				.getNextNode(firstTree.getRoot(), nodeToFind);
		System.out.println(nodeToFind == null ? "null" : nodeToFind.element);
	}

	private static void findCommonManager() {
		BinaryTree<Integer> firstTree = new BinaryTree<>();
		IntStream.range(1, 10)
			.forEach(firstTree::insert);
		/*
		 * {4,6},{8,7},{5,3}
		 **/
		Node<Integer> commonManager = BinaryTreeUtils
				.getLowestCommonParent(firstTree.getRoot(), 3, 7);
		System.out.println("\nCommon Manager: " + commonManager.element);
	}

	private static void isIdentical() {
		BinaryTree<Integer> firstTree = new BinaryTree<>();
		BinaryTree<Integer> secondTree = new BinaryTree<>();
		
		IntStream.range(1, 8)
			.forEach(i -> {
				firstTree.insert(i);
				secondTree.insert(i);
			});
		secondTree.insert(10);
		boolean isIdentical = BinaryTreeUtils
				.isIdentical(firstTree.getRoot(),
						secondTree.getRoot());
		System.out.println("isIdentical: " + isIdentical);
		
		TreeTraversal traverse = new TreeTraversal();
		traverse.dfsTraversal(firstTree.getRoot());
		System.out.println();
		traverse.dfsTraversal(secondTree.getRoot());
	}
}
