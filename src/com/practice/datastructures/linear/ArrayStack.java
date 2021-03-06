package com.practice.datastructures.linear;

public class ArrayStack<T> {

	private int size;
	private int maxSize;
	private Object[] elements;
	
	public ArrayStack() {
		maxSize = 10;
		elements = new Object[maxSize];
	}
	public ArrayStack(int size) {
		maxSize = size;
		elements = new Object[maxSize];
	}
	public boolean push(T element) {
		
		if (size < maxSize) {
			elements[size++] = element;
			return true;
		}
		return false;
	}
	public T pop() {
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
