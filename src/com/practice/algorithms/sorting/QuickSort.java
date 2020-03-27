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
				
				boolean isPivotLessOrEquals = pivotElement <= array[i];
				boolean isPivotHigherOrEquals = pivotElement >= array[j];
				if (isPivotLessOrEquals && isPivotHigherOrEquals) {
					/*
					 * Swap only if pivot element is lower or equals
					 * than i'th element of an array and higher or
					 * equals than j'th element of an array 
					 **/
					swap(array, i, j);
				} else {
					if (!isPivotLessOrEquals) {
						/*
						 * Increment the index of i when pivot element is
						 * higher than i'th element.
						 **/
						i++;
					}
					if (!isPivotHigherOrEquals) {
						/*
						 * Decrement the index j when pivot element is lower
						 * than j'th element.
						 **/
						j--;
					}
				}
			}
			/*
			 * Below we are partitioning the array and follow the same
			 * steps above.
			 **/
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
