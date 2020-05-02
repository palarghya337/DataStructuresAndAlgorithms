package com.practice.datastructures.linear;

public interface Queue<T> {

	/**
	 * Method to add or insert an element in the queue.
	 * @param element
	 */
	void add(T element);
	/**
	 * This method removes the first element from the queue.
	 * If there is no element in the queue then it will
	 * throw NullPointerException.
	 * @return T
	 * @throws NullPointerException
	 */
	T remove();
	/**
	 * This method removes the first element from the queue.
	 * If there is no element in the queue then it will
	 * return null.
	 * @return T
	 */
	T poll();
	/**
	 * This method does not remove the element from the queue,
	 * instead it just returns the first element present in the
	 * queue.
	 *  
	 * @return T
	 */
	T peek();
	/**
	 * Method to return the size of the queue
	 * @return size
	 */
	int size();
}
