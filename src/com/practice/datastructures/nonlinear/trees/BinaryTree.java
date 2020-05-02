package com.practice.datastructures.nonlinear.trees;

import java.util.Objects;

import com.practice.datastructures.linear.LinkedQueue;
import com.practice.datastructures.linear.Queue;

public class BinaryTree<T> implements ITree<T> {

	private int level;
	private Node<T> root;
	private Node<T> current;
	private Queue<Node<T>> queue;
	
	public BinaryTree() {
		queue = new LinkedQueue<Node<T>>();
	}
	
	@Override
	public void insert(T element) {
		
		Objects.requireNonNull(element);
		Node<T> newNode = null;
		if (level == 0) {
			
			root = new Node<T>(element);;
			current = root;
			level = 1;
		} else {
			if (current.left == null) {
				
				newNode = new Node<T>(element);
				queue.add(newNode);
				current.left = newNode;
			} else if (current.right == null) {
				
				newNode = new Node<T>(element);
				queue.add(newNode);
				current.right = newNode;
			} else {
				
				current = queue.poll();
				insert(element);
				level++;
			}
		}
	}

	@Override
	public Node<T> insert(T element, Node<T> newNode) {
		// TODO need to implement
		return null;
	}

	@Override
	public Node<T> getRoot() {
		return root;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeAllNodes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Node<T> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int level() {
		return level;
	}
}
