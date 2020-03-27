package com.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {

	public static void main(String[] args) {
		
		int array[] = {10, 16, 18, 2, 15, 6, 3, 9, 5};
		Random random = new Random();
		array = IntStream.generate(() -> random.nextInt(40))
				.distinct()
				.limit(10)
				.toArray();
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	public static void sort(int[] array) {
		sort2(array, 0, array.length - 1);
	}
	private static void sort(int[] array, int low, int high) {

		if (low < high) {
			
			int i = low;
			int j = high;
			/*
			 * We are assigning pivot element as the last element
			 * in an array of low to high index.
			 **/
			int pivotElement = array[high];
			while (i < j) {
				if (pivotElement < array[i]) {
					/*
					 * If i'th element is greater then pivot element
					 * then we need to move the elements in the below
					 * mentioned way -
					 * i'th to j'th
					 * (j-1) to i'th
					 * and we can move pivot to (j - 1) th location
					 **/
					array[j--] = array[i];
					array[i] = array[j];
					array[j] = pivotElement;
					System.out.println(Arrays.toString(array));
				} else {
					/*
					 * We can simply ignore those elements which is
					 * less than pivot element as we are considering
					 * pivot element as the highest element.
					 **/
					i++;
				}
			}
			sort(array, low, i - 1);
			sort(array, i, high);
		}
	}
	private static void sort2(int[] array, int low, int high) {
		
		if (low < high) {
			
			int i = low;
			int j = high;
			int pivotElement = array[low];
			while (i < j) {
				
				boolean isHigherThanPivot = pivotElement <= array[i];
				boolean isLowerThanPivot = pivotElement >= array[j];
				if (isHigherThanPivot && isLowerThanPivot) {
					swap(array, i, j);
				}
				if (!isHigherThanPivot) {
					i++;
				}
				if (!isLowerThanPivot) {
					j--;
				}
			}
			sort2(array, low, j);
			sort2(array, j + 1, high);
		}
	}
	private static void swap(int[] array, int i, int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		System.out.println(Arrays.toString(array));
	}
}
