package com.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class HeapSort {

	public static void main(String[] args) {
		
		int maxSize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.limit(maxSize)
				.toArray();
		
		System.out.println(Arrays.toString(array));
		new HeapSort().sort(array);
		System.out.println(Arrays.toString(array));
	}
	public void sort(int[] array) {
		
		int arraySize = 0;
		if (array == null || (arraySize = array.length) < 2) {
			return;
		}
		buildMaxHeap(array, arraySize);
		while (arraySize --> 1) {
			
			swap(array, 0, arraySize);
			heapify(array, arraySize, 0);
		}
	}
	/**
	 * Method to build the max heap, which means parent node
	 * of a tree should contains highest element than it's
	 * child.
	 * 
	 * @param array which we should heapify
	 * @param arraySize size of the array.
	 */
	private void buildMaxHeap(int[] array, int arraySize) {
		/*
		 * We will start doing heapify from parent of last node
		 * because leaf nodes does not have child and we do
		 * not need to heapify those.
		 **/
		int parentOfLastNode = (arraySize - 1) / 2;
		while (parentOfLastNode > -1) {
			
			heapify(array, arraySize, parentOfLastNode);
			parentOfLastNode--;
		}
	}
	/**
	 * @param array
	 * @param arraySize
	 * @param parentIndex
	 */
	private void heapify(int[] array, int arraySize,
			int parentIndex) {
		
		int largest = parentIndex;
		int right = (parentIndex + 1) * 2;
		int left = right - 1;
		/*
		 * In the below code we will find the highest element
		 * among the parent and their left and right child node.
		 **/
		largest = getHighestElementIndex(array, arraySize, largest, left);
		largest = getHighestElementIndex(array, arraySize, largest, right);
		if (largest != parentIndex) {
			/*
			 * if parent is not the highest element then we
			 * swap the highest element with the parent element
			 * and call the hepify method again for the founded
			 * highest element index. This process will continue
			 * until the sub tree is hepified.
			 **/
			swap(array, parentIndex, largest);
			heapify(array, arraySize, largest);
		}
	}
	/**
	 * Method to get the highest element index. This method
	 * will check whether parent index has the highest element
	 * or the child index. If child contains the highest element
	 * then return the child index otherwise parent index.
	 * 
	 * @param array
	 * @param arraySize
	 * @param parentIndex
	 * @param childIndex
	 * @return largestElementIndex
	 */
	private int getHighestElementIndex(int[] array, int arraySize,
			int parentIndex, int childIndex) {
		
		return childIndex < arraySize
				&& array[childIndex] > array[parentIndex]
						? childIndex : parentIndex;
	}
	/**
	 * Method to swap the elements.
	 * @param array
	 * @param parentIndex
	 * @param childIndex
	 */
	private void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
	}
}
