package com.practice.datastructures.linear;

public class ArrayQueue<T> implements Queue<T>{

	private int addIndex;
	private int removeIndex;
	private int maxSize;
	private int size;
	private Object[] elements;
	
	public ArrayQueue() {
		maxSize = 10;
		elements = new Object[maxSize];
	}
	public ArrayQueue(int size) {
		maxSize = size;
		elements = new Object[maxSize];
	}
	@Override
	public void add(T element) {
		
		if (addIndex >= maxSize) {
			addIndex = 0;
		}
		if (addIndex < maxSize && elements[addIndex] == null) {
			elements[addIndex++] = element;
		}
	}
	@Override
	public T poll() {
		
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
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
