package com.practice.datastructures.nonlinear.trees;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		
		InsertionBinarySearchTree<Integer> inputTree =
				new InsertionBinarySearchTree<>();
		inputTree.insert(6);
		inputTree.insert(4);
		inputTree.insert(8);
		inputTree.insert(3);
		inputTree.insert(7);
		inputTree.insert(5);
		inputTree.insert(9);
		System.out.println();
	}
}
