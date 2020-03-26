package com.practice.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int array[] = {10, 16, 18, 2, 15, 6, 3, 9, 5};
		System.out.println(Arrays.toString(array));
		sort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	public static void sort(int[] array, int low, int high) {

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
}
