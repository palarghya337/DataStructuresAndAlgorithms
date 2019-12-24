package com.practice.datastructures.trees;

public class BinaryTree extends Node {

	public void add(int value) {
		
		if (value > this.value) {
			if (right == null) {
				right = new Node(value);
			} else {
//				right.add(value);
			}
		}
	}
}
