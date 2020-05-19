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
	private static void buildMinHeap(int[] array,
			int arraySize) {

		/*
		 * We will start heapifying from parent of last node because
		 * leaf nodes will always be heapified.
		 **/
		int parent = arraySize / 2;
		while (parent > -1) {
			
			heapify(array, arraySize, parent);
			parent--;
		}
	}
	private static void heapify(int[] array, int arraySize, int parent) {
		
		int smallestIndex = parent;
		int rightIndex = (parent + 1) * 2;
		int leftIndex = rightIndex - 1;
		smallestIndex = getSmallestIndex(array, arraySize,
				smallestIndex, leftIndex);
		smallestIndex = getSmallestIndex(array, arraySize,
				smallestIndex, rightIndex);
		if (smallestIndex != parent) {
			/*
			 * If parent element is not the smallest element then
			 * swap parent element with the smallest element and
			 * then again heapify the founded smallest element.
			 **/
			swap(array, parent, smallestIndex);
			heapify(array, arraySize, smallestIndex);
		}
	}
	private static int getSmallestIndex(int[] array, int arraySize,
			int assumedSmallestIndex, int currentIndex) {
		return currentIndex < arraySize && array[currentIndex] < array[assumedSmallestIndex] ?
				currentIndex : assumedSmallestIndex;
	}
	private static void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
		System.out.println(Arrays.toString(array));
	}
}
