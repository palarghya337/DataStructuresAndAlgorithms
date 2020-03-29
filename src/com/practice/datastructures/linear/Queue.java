package com.practice.datastructures.linear;

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
		
		if (addIndex >= maxSize) {
			addIndex = 0;
		}
		if (addIndex < maxSize && elements[addIndex] == null) {
			elements[addIndex++] = element;
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
		}
		return element;
	}
	public boolean isEmpty() {
		return addIndex - removeIndex == 0;
	}
}
