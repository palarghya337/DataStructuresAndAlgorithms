package com.practice.datastructures.nonlinear.trees;

import com.practice.datastructures.nonlinear.trees.ITree.Node;

public class BinarySearchTreeUtil {

	private BinarySearchTreeUtil() {
		super();
	}
	/**
	 * Method to calculate the height of a tree from a given node.
	 * @param head
	 * @return height
	 */
	public static int height(Node<?> head) {
		
		int height = 0;
		if (head != null) {
			
			int leftHeight = height(head.left) + 1;
			int rightHeight = height(head.right) + 1;
			height = leftHeight > rightHeight ? leftHeight : rightHeight;
		}
		return height;
	}
	/**
	 * This method will take the head node of two trees and
	 * will check whether both are identical or not. If both
	 * trees are identical then will return true otherwise
	 * false.
	 * 
	 * @param firstTreeHead
	 * @param secondTreeHead
	 * @return boolean
	 */
	public static boolean isIdentical(Node<?> firstTreeHead,
			Node<?> secondTreeHead) {
		
		if (firstTreeHead != null && secondTreeHead != null) {
			if (firstTreeHead.element == secondTreeHead.element) {
				boolean isLeftIdentical = isIdentical(
						firstTreeHead.left, secondTreeHead.left);
				boolean isRightIdentical = isIdentical(
						firstTreeHead.right, secondTreeHead.right);
				return isLeftIdentical && isRightIdentical;
			}
		} else if (firstTreeHead == null && secondTreeHead == null) {
			return true;
		}
		return false;
	}
}
