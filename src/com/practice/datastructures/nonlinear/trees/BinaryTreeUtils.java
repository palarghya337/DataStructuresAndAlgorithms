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
	/**
	 * @param <T>
	 * @param root
	 * @param firstNodeElement
	 * @param secondNodeElement
	 * @return commonManager
	 */
	public static <T> Node<T> findCommonParent(Node<T> root,
			T firstNodeElement, T secondNodeElement) {
		
		if (root == null || firstNodeElement == null || secondNodeElement == null) {
			return null;
		}
		
		Node<T> parentIsInLeft = null;
		Node<T> left = root.left;
		if (left != null) {
			if (firstNodeElement.equals(left.element)
					|| secondNodeElement.equals(left.element)) {
				
				parentIsInLeft = root;
			} else {
				parentIsInLeft = findCommonParent(left,
						firstNodeElement, secondNodeElement);
			}
		}
		
		Node<T> parentIsInRight = null;
		Node<T> right = root.right;
		if (right != null) {
			if (firstNodeElement.equals(right.element)
					|| secondNodeElement.equals(right.element)) {

				parentIsInRight = root;
			} else {
				parentIsInRight = findCommonParent(right,
						firstNodeElement, secondNodeElement);
			}
		}
		
		if (parentIsInLeft == null && parentIsInRight == null) {
			return null;
		} else if (parentIsInLeft == null) {
			return parentIsInRight;
		} else if (parentIsInRight == null) {
			return parentIsInLeft;
		} else if (parentIsInLeft.element.equals(parentIsInRight.element)) {
			return parentIsInLeft;
		} else {
			return root;
		}
	}
}
