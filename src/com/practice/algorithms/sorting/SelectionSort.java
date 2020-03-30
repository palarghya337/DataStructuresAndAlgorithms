package com.practice.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int array[] = {10, 16, 18, 2, 15, 6, 3, 9, 5};
		/*
		Random random = new Random();
		array = IntStream.generate(() -> random.nextInt(40))
				.distinct()
				.limit(10)
				.toArray();
		*/
		System.out.println(Arrays.toString(array));
		sort(array);
	}

	private static void sort(int[] array) {
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			/*
			 * Assuming the first element of a sub-array is the
			 * smallest element.
			 **/
			int smallestElementIndex = i;
			int smallestElement = array[smallestElementIndex];
			for (int j = i + 1; j < arrayLength; j++) {
				if (smallestElement > array[j]) {
					/*
					 * If j'th index element is smaller then the
					 * element present in the variable "smallestElement"
					 * then change the smallest element and it's
					 * index.
					 **/
					smallestElementIndex = j;
					smallestElement = array[smallestElementIndex];
				}
			}
			/*
			 * Swap the smallest element with the i'th index element.
			 **/
			array[smallestElementIndex] = array[i];
			array[i] = smallestElement;
			System.out.println(Arrays.toString(array));
		}
	}
}
