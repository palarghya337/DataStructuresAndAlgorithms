package com.practice.datastructures.nonlinear.trees;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TurnIntoMaxHeap {

	public static void main(String[] args) {
		
		int maxSize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.limit(maxSize)
				.toArray();
		
		array = new int[] {9,33,11,5,18,25,29,22,8,9};
//		array = new int[] {19, 9, 37, 12, 16, 38, 19, 36, 24, 11};
		System.out.println(Arrays.toString(array));
		buildMaxHeap(array, array.length);
	}

	public static void buildMaxHeap(int[] array, int arraySize) {
		
		int parentOfLastNode = (arraySize - 1) / 2;
		while (parentOfLastNode > -1) {
			
			heapify(array, parentOfLastNode, arraySize);
			parentOfLastNode--;
		}
	}
	private static void heapify(int[] array, int parent,
			int arraySize) {
		
		int largest = parent;
		int right = (parent + 1) * 2;
		int left = right - 1;
		largest = getHighestElementIndex(array, arraySize, largest, left);
		largest = getHighestElementIndex(array, arraySize, largest, right);
		if (largest != parent) {
			
			swap(array, parent, largest);
			heapify(array, largest, arraySize);
		}
	}

	private static int getHighestElementIndex(int[] array, int arraySize,
			int assumedLargestIndex, int currentIndex) {
		
		if (currentIndex < arraySize
				&& array[currentIndex] > array[assumedLargestIndex]) {
			return currentIndex;
		}
		return assumedLargestIndex;
	}

	private static void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
		System.out.println(Arrays.toString(array));
	}
}
