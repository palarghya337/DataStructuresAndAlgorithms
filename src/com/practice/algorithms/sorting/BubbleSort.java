package com.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BubbleSort {

	public static void main(String[] args) {

		int arraySize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.distinct().limit(arraySize).toArray();
		System.out.println(Arrays.toString(array));
		sort(array, arraySize);
		System.out.println(Arrays.toString(array));
	}

	private static void sort(int[] array, int arrayLength) {
		
		for (int i = arrayLength - 1; i > -1; i--) {
			for (int j = 0; j < i; j++) {
				
				int k = j + 1;
				if (array[j] > array[k]) {
					
					int temp = array[j];
					array[j] = array[k];
					array[k] = temp;
				}
			}
		}
	}
}
