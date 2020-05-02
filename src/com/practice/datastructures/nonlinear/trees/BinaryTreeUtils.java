package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.ITree.Node;

public class BinaryTreeUtils {

	private BinaryTreeUtils() {
		super();
	}
	/**
	 * Method to check given two trees are identical or not.
	 * If both the trees are identical then returns true
	 * otherwise return false.
	 * 
	 * @param <T>
	 * @param firstTreeRoot
	 * @param secondTreeRoot
	 * @return boolean
	 */
	public static <T> boolean isIdentical(Node<T> firstTreeRoot,
			Node<T> secondTreeRoot) {
		
		if (firstTreeRoot == null && secondTreeRoot == null) {
			return true;
		}
		if (firstTreeRoot != null && secondTreeRoot != null
				&& firstTreeRoot.element.equals(secondTreeRoot.element)) {

			boolean isLeftIdentical = isIdentical(firstTreeRoot
					.left, secondTreeRoot.left);
			boolean isRightIdentical = isIdentical(firstTreeRoot
					.right, secondTreeRoot.right);
			return isLeftIdentical && isRightIdentical;
		}
		return false;
	}
}
