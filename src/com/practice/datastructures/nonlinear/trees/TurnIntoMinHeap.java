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
		convertToMinHeap(array, array.length);
		System.out.println(Arrays.toString(array));
	}
	private static void convertToMinHeap(int[] array,
			int arraySize) {

		int parent = arraySize / 2;
		boolean isSwaped = false;
		while (parent > -1) {
			
			int right = (parent + 1) * 2;
			int left = right - 1;
			if (left < arraySize
					&& array[parent] > array[left]) {
				
				swap(array, parent, left);
				isSwaped = true;
			}
			if (right < arraySize
					&& array[parent] > array[right]) {
				
				swap(array, parent, right);
				isSwaped = true;
			}
			parent--;
		}
		if (isSwaped) {
			convertToMinHeap(array, arraySize);
		}
	}
	private static void swap(int[] array, int parentIndex,
			int childIndex) {

		int temp = array[parentIndex];
		array[parentIndex] = array[childIndex];
		array[childIndex] = temp;
		System.out.println(Arrays.toString(array));
	}
}
