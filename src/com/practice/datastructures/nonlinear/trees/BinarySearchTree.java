package com.practice.datastructures.nonlinear.trees;

public class BinarySearchTree<T extends Comparable<T>>
	implements ITree<T> {
	
	private Node<T> root;
	
	@Override
	public void insert(T element) {
		root = insert(element, root);
	}
	@Override
	public Node<T> insert(T element, Node<T> localHead) {
		
		if (localHead != null) {
			if (element.compareTo(localHead.element) < 1 ) {
				
				localHead.left = insert(element, localHead.left);
			} else {
				localHead.right = insert(element, localHead.right);
			}
			return localHead;
		}
		return new Node<>(element);
	}
	@Override
	public Node<T> getRoot() {
		return root;
	}
	@Override
	public int height() {
		return BinarySearchTreeUtil.height(root);
	}
	@Override
	public void removeAllNodes() {
		this.root = removeNodes(this.root);
	}
	private Node<T> removeNodes(Node<T> headNode) {
		
		if (headNode != null) {
			
			headNode.left = removeNodes(headNode.left);
			headNode.right = removeNodes(headNode.right);
			headNode = null;
		}
		return headNode;
	}
	@Override
	public void remove(Node<T> node) {
		
		if (node == null) {
			throw new RuntimeException("Removing node can not be null");
		}
		remove(node, root, null);
	}
	public void remove(Node<T> node, Node<T> root, Node<T> previous) {
		
		if (root.element.equals(node.element)) {
//			if (previous)
		}
	}
	@Override
	public int level() {
		// TODO need to implement
		return 0;
	}
}
