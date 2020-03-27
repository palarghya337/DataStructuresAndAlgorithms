package com.practice.datastructures.linear;

public class Stack<T> {

	private int size;
	private int maxSize;
	private Object[] elements;
	
	public Stack() {
		maxSize = 10;
		init();
	}
	private void init() {
		size = maxSize;
		elements = new Object[maxSize];
	}
	public Stack(int size) {
		maxSize = size;
		init();
	}
	public boolean add(T element) {
		
		if (size > 0) {
			elements[--size] = element;
			return true;
		}
		return false;
	}
	public T remove() {
		if (size >= maxSize) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T element = (T) elements[size];
		elements[size++] = null;
		return element;
	}
}
