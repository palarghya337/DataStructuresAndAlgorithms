package com.practice.datastructures.nonlinear.trees;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TurnIntoMinHeap {

	public static void main(String[] args) {
		
		int maxSize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.limit(maxSize)
				.toArray();
		
//		array = new int[] {9,33,11,5,18,25,29,22,8,9};
//		array = new int[] {19, 9, 37, 12, 16, 38, 19, 36, 24, 11};
		System.out.println(Arrays.toString(array));
		buildMinHeap(array, array.length);
		System.out.println(Arrays.toString(array));
	}
	/**
	 * Method to build the min heap, which means parent node
	 * of a tree should contains smallest element than it's
	 * child.
	 * 
	 * @param array which we should heapify
	 * @param arraySize size of the array.
	 */
	public static void buildMinHeap(int[] array,
			int arraySize) {
		/*
		 * We will start doing heapify from parent of last node
		 * because leaf nodes does not have child and we do
		 * not need to heapify those.
		 **/
		int parent = arraySize / 2;
		while (parent > -1) {
			
			heapify(array, arraySize, parent);
			parent--;
		}
	}
	/**
	 * @param array
	 * @param arraySize
	 * @param parent
	 */
	private static void heapify(int[] array, int arraySize, int parent) {
		
		int smallestIndex = parent;
		int rightIndex = (parent + 1) * 2;
		int leftIndex = rightIndex - 1;
		/*
		 * In the below code we will find the highest element
		 * among the parent and their left and right child node.
		 **/
		smallestIndex = getSmallestIndex(array, arraySize,
				smallestIndex, leftIndex);
		smallestIndex = getSmallestIndex(array, arraySize,
				smallestIndex, rightIndex);
		if (smallestIndex != parent) {
			/*
			 * if parent is not the smallest element then we
			 * swap the smallest element with the parent element
			 * and call the hepify method again for founded
			 * smallest element index. This process will continue
			 * until the sub tree is hepified.
			 **/
			swap(array, parent, smallestIndex);
			heapify(array, arraySize, smallestIndex);
		}
	}
	/**
	 * Method to get the smallest element index. This method
	 * will check whether parent index has the smallest element
	 * or the child index. If child contains the smallest element
	 * then return the child index otherwise parent index.
	 * 
	 * @param array
	 * @param arraySize
	 * @param parentIndex
	 * @param childIndex
	 * @return largestElementIndex
	 */
	private static int getSmallestIndex(int[] array, int arraySize,
			int parentIndex, int childIndex) {
		return childIndex < arraySize
				&& array[childIndex] < array[parentIndex]
						? childIndex : parentIndex;
	}
	/**
	 * Method to swap the elements.
	 * @param array
	 * @param parentIndex
	 * @param childIndex
	 */
	private static void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
//		System.out.println(Arrays.toString(array));
	}
}
