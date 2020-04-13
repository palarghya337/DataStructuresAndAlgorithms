package com.practice.datastructures.linear;

public class Stack<T> {

	private int size;
	private int maxSize;
	private Object[] elements;
	
	public Stack() {
		maxSize = 10;
		elements = new Object[maxSize];
	}
	public Stack(int size) {
		maxSize = size;
		elements = new Object[maxSize];
	}
	public boolean add(T element) {
		
		if (size < maxSize) {
			elements[size++] = element;
			return true;
		}
		return false;
	}
	public T remove() {
		if (size < 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T element = (T) elements[--size];
		elements[size] = null;
		return element;
	}
	public boolean isEmpty() {
		return size == 0;
	}
}
