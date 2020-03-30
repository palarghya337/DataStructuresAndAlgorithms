package com.practice.algorithms.sorting;

import java.util.Arrays;

public class InsertsionSort {

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

			int j = i;
			int small = array[i + 1];
			while (j >= 0 && array[j] > small) {
				/*
				 * if element of index i is greater than element
				 * of index (i + 1) then move all the previous
				 * i'th element to (i + 1)'th element. This move
				 * will happen till it finds the smaller element
				 * or it reaches the first position. Then copy
				 * the element to the last found (index + 1)
				 * position.
				 **/
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = small;
			System.out.println(Arrays.toString(array));
		}
	}
}
