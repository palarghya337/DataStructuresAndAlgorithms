package com.practice.datastructures.linear;

import java.util.Arrays;

public class Queue<T> {

	private int addIndex;
	private int removeIndex;
	private int maxSize;
	private Object[] elements;
	
	public Queue() {
		maxSize = 10;
		elements = new Object[maxSize];
	}
	public boolean add(T element) {
		
		if (addIndex < maxSize) {
			elements[addIndex++] = element;
			System.out.println(Arrays.toString(elements));
			return true;
		} else if (elements[0] == null) {
			addIndex = 0;
			elements[addIndex++] = element;
			System.out.println(Arrays.toString(elements));
			return true;
		}
		return false;
	}
	public T remove() {
		
		if (removeIndex >= maxSize) {
			removeIndex = 0;
		}
		@SuppressWarnings("unchecked")
		T element = (T) elements[removeIndex];
		if (element != null) {
			elements[removeIndex++] = null;
			System.out.println(Arrays.toString(elements));
		}
		return element;
	}
}
