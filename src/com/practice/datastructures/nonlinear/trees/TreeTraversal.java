package com.practice.datastructures.nonlinear.trees;

import java.util.HashMap;
import java.util.Map;

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
		Node<Integer> headNode = inputTree.getRoot();
		
		TreeTraversal traversal = new TreeTraversal();
		System.out.print("Pre Order Traversal: ");
		traversal.preOrderTraversal(headNode);
		System.out.print("\nPost Order Traversal: ");
		traversal.postOrderTraversal(headNode);
		System.out.print("\nInOrder Traversal: ");
		traversal.inOrderTraversal(headNode);
		System.out.print("\nBFS Traversal: ");
		traversal.levelOrderTraversal(headNode);
		System.out.print("\nDFS Traversal: ");
		traversal.dfsTraversal(headNode);
		System.out.print("\nLeft View of a Tree: ");
		traversal.leftView(headNode);
		System.out.print("\nRight View of a Tree: ");
		traversal.rightView(headNode);
		System.out.print("\nBottom View of a Tree: ");
		traversal.bottomView(headNode);
		System.out.print("\nTop View of a Tree: ");
		traversal.topView(headNode);
	}

	@Override
	public <T> void preOrderTraversal(Node<T> head) {
		if (head != null) {
			System.out.print(head.element + " ");
			preOrderTraversal(head.left);
			preOrderTraversal(head.right);
		}
	}

	@Override
	public <T> void postOrderTraversal(Node<T> head) {
		
		if (head != null) {
			postOrderTraversal(head.left);
			postOrderTraversal(head.right);
			System.out.print(head.element + " ");
		}
	}

	@Override
	public <T> void inOrderTraversal(Node<T> head) {

		if (head != null) {
			inOrderTraversal(head.left);
			System.out.print(head.element + " ");
			inOrderTraversal(head.right);
		}
	}
	@Override
	public <T> void levelOrderTraversal(Node<T> head) {
		
		int height = BinarySearchTreeUtil.height(head);
		for (int i = 1; i <= height; i++) {
			levelOrderTraversal(head, i);
		}
	}

	private <T> void levelOrderTraversal(Node<T> head, int level) {
		
		if (head != null) {
			if (level == 1) {
				System.out.print(head.element + " ");
			} else {
				levelOrderTraversal(head.left, level - 1);
				levelOrderTraversal(head.right, level - 1);
			}
		}
	}
	@Override
	public <T> void dfsTraversal(Node<T> head) {
		
		preOrderTraversal(head);
	}

	@Override
	public <T> void spiralOrderTraversal(Node<T> head) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void reverseLevelOrderTraversal(Node<T> head) {
		// TODO Auto-generated method stub
		
	}
	public <T> void leftView(Node<T> root) {
		if (root != null) {
			System.out.print(root.element + " ");
			if (root.left == null) {
				leftView(root.right);
			} else {
				leftView(root.left);
			}
		}
	}
	public <T> void rightView(Node<T> root) {
		
		if (root != null) {
			
			System.out.print(root.element + " ");
			if (root.right == null) {
				rightView(root.left);
			} else {
				rightView(root.right);
			}
		}
	}
	public <T> void bottomView(Node<T> root) {
		
		if (root != null) {
			
			int hight = BinarySearchTreeUtil.height(root);
			Map<Integer, T> bottomViewData = new HashMap<>();
			for (int i = 1; i <= hight; i++) {
				bottomView(root, i, 0, bottomViewData);
			}
			System.out.print(bottomViewData.values());
		}
	}

	private <T> void bottomView(Node<T> root,
			int level, int distance,
			Map<Integer, T> bottomViewData) {
		
		if (root != null) {
			if (level == 1) {
				
				bottomViewData.put(distance, root.element);
				return;
			}
			bottomView(root.left, level - 1, distance - 1, bottomViewData);
			bottomView(root.right, level - 1, distance + 1, bottomViewData);
		}
	}
	public <T> void topView(Node<T> root) {
		
		int hight = BinarySearchTreeUtil.height(root);
		Map<Integer, T> topViewData = new HashMap<>();
		for (int i = 1; i <= hight; i++) {
			topView(root, i, 0, topViewData);
		}
		System.out.print(topViewData.values());
	}

	private <T> void topView(Node<T> root, int level,
			int distance, Map<Integer, T> topViewData) {
		
		if (root != null) {
			if (level == 1) {
				if (!topViewData.containsKey(distance)) {
					
					topViewData.put(distance, root.element);
				}
				return;
			}
			topView(root.left, level - 1, distance - 1, topViewData);
			topView(root.right, level - 1, distance + 1, topViewData);
		}
	}
}
