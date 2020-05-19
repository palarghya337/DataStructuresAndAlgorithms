package com.practice.datastructures.nonlinear.trees;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class FindKthLargestElement {

	public static void main(String[] args) {
		
		int maxSize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.limit(maxSize)
				.toArray();
		System.out.println(Arrays.toString(array));
		System.out.println(getKthLargestElement(array, array.length));
	}
	public static int getKthLargestElement(int[] array, int k) {
		
		int arraySize = 0;
		if (array != null && (arraySize = array.length) >= k) {

			TurnIntoMaxHeap.buildMaxHeap(array, arraySize);
			while (k > 1) {
				
				int temp = array[0];
				array[0] = array[--arraySize];
				array[arraySize] = temp;
				TurnIntoMaxHeap.heapify(array, 0, arraySize);
				k--;
			}
		}
		System.out.println("-----------------------");
		System.out.println(Arrays.toString(array));
		return array[0];
	}
}
