package com.practice.testclass;

import java.util.stream.IntStream;

import com.practice.datastructures.nonlinear.trees.BinaryTree;
import com.practice.datastructures.nonlinear.trees.BinaryTreeUtils;
import com.practice.datastructures.nonlinear.trees.ITree.Node;
import com.practice.datastructures.nonlinear.trees.TreeTraversal;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		isIdentical();
		
		findCommonManager();
	}

	private static void findCommonManager() {
		BinaryTree<Integer> firstTree = new BinaryTree<>();
		IntStream.range(1, 10)
			.forEach(firstTree::insert);
		/*
		 * {4,6},{8,7},{5,3}
		 **/
		Node<Integer> commonManager = BinaryTreeUtils
				.findCommonParent(firstTree.getRoot(), 3, 7);
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
