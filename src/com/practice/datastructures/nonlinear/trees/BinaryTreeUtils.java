package com.practice.datastructures.nonlinear.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	 * @return lowestCommonParent
	 */
	public static <T> Node<T> getLowestCommonParent(Node<T> root,
			T firstNodeElement, T secondNodeElement) {
		
		if (root == null || firstNodeElement == null || secondNodeElement == null) {
			return null;
		}
		
		Node<T> parentOfLeft = null;
		Node<T> left = root.left;
		if (left != null) {
			if (firstNodeElement.equals(left.element)
					|| secondNodeElement.equals(left.element)) {
				
				parentOfLeft = root;
			} else {
				parentOfLeft = getLowestCommonParent(left,
						firstNodeElement, secondNodeElement);
			}
		}
		
		Node<T> parentOfRight = null;
		Node<T> right = root.right;
		if (right != null) {
			if (firstNodeElement.equals(right.element)
					|| secondNodeElement.equals(right.element)) {

				parentOfRight = root;
			} else {
				parentOfRight = getLowestCommonParent(right,
						firstNodeElement, secondNodeElement);
			}
		}
		
		if (parentOfLeft == null && parentOfRight == null) {
			return null;
		} else if (parentOfLeft == null) {
			return parentOfRight;
		} else if (parentOfRight == null ||
				parentOfLeft.element.equals(parentOfRight.element)) {
			return parentOfLeft;
		} else {
			return root;
		}
	}
	public static <T> Node<T> getNextNode(Node<T> root,
			Node<T> nodeToFind) {
		
		Map<Integer, Node<T>> levelNode = new HashMap<>();
		findNextNode(root, nodeToFind, 1, levelNode);
		Iterator<Node<T>> ite = levelNode.values().iterator();
		return ite.hasNext() ? ite.next() : null; 
	}
	private static <T> void findNextNode(Node<T> root, Node<T> nodeToFind,
			int level, Map<Integer, Node<T>> nextNode) {

		if (root == null || nodeToFind == null) {
			return;
		}
		if (nodeToFind.element.equals(root.element)) {
			/*
			 * If we find the same for for which we have to find
			 * the next node then add that node into the map and
			 * in the key I am adding level of the current node.
			 **/
			nextNode.put(level, null);
			return;
		}
		
		findNextNode(root.left, nodeToFind, level + 1, nextNode);
		if(nextNode.isEmpty() || !nextNode.containsKey(level)) {
			/*
			 * Check for right node of a tree only when map is
			 * empty or in the no value is present in the same
			 * level.
			 **/
			findNextNode(root.right, nodeToFind, level + 1, nextNode);
		} else {
			/*
			 * Need to update the map only once that means only
			 * then next node in the same level not any other
			 * nodes. And because of this reason I am checking
			 * below condition.
			 **/
			if (nextNode.get(level) == null) {
				nextNode.put(level, root);
			}
		}
	}
	/**
	 * Method to convert a binary tree into a doubly linked
	 * list.
	 * 
	 * @param <T>
	 * @param root node of a binary tree
	 * @return head node of a Doubly Linked List.
	 */
	public static <T> Node<T> getDoublyLinkedList(Node<T> root) {
		
		if (root == null) {
			return null;
		}
		Node<T> right = getDoublyLinkedList(root.right);
		Node<T> left = getDoublyLinkedList(root.left);
		boolean isLeftNull = left == null;
		boolean isRightNull = right == null;
		if (isLeftNull && isRightNull) {
			return root;
		} else if (isLeftNull && !isRightNull) {
			/*
			 * if left null right non null no problem
			 * */
			root.right.left = root;
			return root;
		} if (!isLeftNull && isRightNull) {
			
			left.right = root;
			return left;
		} else {
			
			right.left = root;
			root.right = right;
			Node<T> temp = left;
			Node<T> pre = null;
			while (temp != null) {
				pre = temp;
				temp = temp.right;
			}
			if (pre == null) {
				root.left = left;
				left.right = root;
			} else {
				root.left = pre;
				pre.right = root;
			}
			return left;
		}
	}
}
