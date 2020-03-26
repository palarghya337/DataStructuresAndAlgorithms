package com.practice.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] array = {10, 16, 18, 2, 15, 6, 3, 9, 5};
		System.out.println(Arrays.toString(array));
		sort(array);
	}

	private static void sort(int[] array) {
		
		int arrayLength = array.length;
		for (int i = arrayLength - 1; i > -1; i--) {
			for (int j = 0; j < i; j++) {
				
				int k = j + 1;
				if (array[j] > array[k]) {
					
					int temp = array[j];
					array[j] = array[k];
					array[k] = temp;
					System.out.println(Arrays.toString(array));
				}
			}
		}
	}
}
