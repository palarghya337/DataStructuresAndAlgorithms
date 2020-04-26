package com.practice.datastructures.nonlinear.trees;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		
		ITree<Integer> inputTree =
				new BinarySearchTree<>();
		inputTree.insert(6);
		inputTree.insert(4);
		inputTree.insert(8);
		inputTree.insert(3);
		inputTree.insert(7);
		inputTree.insert(5);
		inputTree.insert(9);
		inputTree.insert(9);
		inputTree.insert(12);
		inputTree.insert(10);
		
		inputTree.removeAllNodes();
		ITree<String> bst = new BinarySearchTree<String>();
		bst.insert("Arindam");
		bst.insert("Gond");
		bst.insert("Anurag");
		bst.insert("Sourav");
		bst.insert("Arghya");
		bst.insert("Kaushik");
		bst.insert("Bibhash");
		
		ITreeTraversal traversal = new TreeTraversal();
		traversal.levelOrderTraversal(bst.getHead());
		System.out.println("\nTree Height: " + inputTree.height());
		
		System.out.println("isIdentical: " + isIdenticalTest());
	}
	private static boolean isIdenticalTest() {
		
		ITree<Integer> firstTree =
				new BinarySearchTree<>();
		firstTree.insert(6);
		firstTree.insert(4);
		firstTree.insert(8);
		firstTree.insert(3);
		
		ITree<Integer> secondTree =
				new BinarySearchTree<>();
		secondTree.insert(6);
		secondTree.insert(4);
		secondTree.insert(8);
		secondTree.insert(3);
		
		return BinarySearchTreeUtil.isIdentical(firstTree.getHead(),
				secondTree.getHead());
	}
}
