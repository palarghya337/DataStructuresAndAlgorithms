package com.practice.testclass;

import java.util.stream.IntStream;

import com.practice.datastructures.nonlinear.trees.BinaryTree;
import com.practice.datastructures.nonlinear.trees.BinaryTreeUtils;
import com.practice.datastructures.nonlinear.trees.ITree.Node;
import com.practice.datastructures.nonlinear.trees.TreeTraversal;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		Node<Integer> firstTreeRoot = new Node<>(1);
		firstTreeRoot.left = new Node<>(2);
		firstTreeRoot.right = new Node<>(3);
		firstTreeRoot.left.left = new Node<>(4);
		firstTreeRoot.left.right = new Node<>(5);
		firstTreeRoot.right.left = new Node<>(6);
		firstTreeRoot.right.right = new Node<>(7);
		
		Node<Integer> secondTreeRoot = new Node<>(10);
		secondTreeRoot.left = new Node<>(2);
		secondTreeRoot.right = new Node<>(3);
		secondTreeRoot.left.left = new Node<>(4);
		secondTreeRoot.left.right = new Node<>(5);
		secondTreeRoot.right.left = new Node<>(6);
		secondTreeRoot.right.right = new Node<>(7);
		boolean isIdentical = BinaryTreeUtils
				.isIdentical(firstTreeRoot, secondTreeRoot);
		System.out.println("isIdentical: " + isIdentical);
		
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		IntStream.range(1, 10).forEach(binaryTree::insert);
		TreeTraversal traverse = new TreeTraversal();
		traverse.inOrderTraversal(binaryTree.getRoot());
		System.out.println("\nLevel: " + binaryTree.level());
	}
}
