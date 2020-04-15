package com.practice.datastructures.nonlinear.trees;

public class BinarySearchTree<T extends Comparable<T>>
	implements ITree<T> {
	
	private Node<T> head;
	
	@Override
	public void insert(T element) {
		head = insert(element, head);
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
	public Node<T> getHead() {
		return head;
	}
	@Override
	public int height() {
		return BinarySearchTreeUtil.height(head);
	}
	@Override
	public void removeAllNodes() {
		this.head = removeNodes(this.head);
	}
	private Node<T> removeNodes(Node<T> headNode) {
		
		if (headNode != null) {
			
			headNode.left = removeNodes(headNode.left);
			headNode.right = removeNodes(headNode.right);
			headNode = null;
		}
		return headNode;
	}
}
