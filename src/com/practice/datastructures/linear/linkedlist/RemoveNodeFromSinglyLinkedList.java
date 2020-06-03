package com.practice.datastructures.linear.linkedlist;

import com.practice.datastructures.linear.linkedlist.SinglyLinkedList.Node;

public class RemoveNodeFromSinglyLinkedList {

	public static <T> void remove(Node<T> node) {
		
		if (node != null) {
			
			Node<T> next = node.next;
			if (next != null) {
				
				node.element = next.element;
				node.next = next.next;
				next.next = null;
				next.element = null;
				next = null;
			} else {
				node = node.next;
			}
		}
	}
}
