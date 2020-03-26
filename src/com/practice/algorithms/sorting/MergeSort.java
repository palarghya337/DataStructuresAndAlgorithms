package com.practice.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] array = {10, 16, 18, 2, 15, 6, 3, 9, 5};
		System.out.println(Arrays.toString(array));
		sort(array);
	}
	public static void sort(int[] array) {
		divide(array, 0, array.length - 1);
	}

	private static void divide(int[] array, int start, int end) {
		
		if (start < end) {
			int mid = (start + end) / 2;
			divide(array, start, mid);
			divide(array, mid+1, end);
			merge(array, start, mid, end);
		}
	}

	/**
	 * @param array
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void merge(int[] array, int start, int mid, int end) {
		
		int j = 0;
		int firstHalfIndex = start;
		int sendHalfIndex = mid + 1;
		int[] tempArr = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			/* 
			 * Below scenario we are copying the array elements into
			 * temp array after dividing an array into smaller parts.
			 * Need to compare both side arrays first element with another
			 * side. If first side element is less then second element
			 * then copy that into temp array.
			 **/
			if (firstHalfIndex <= mid && (sendHalfIndex > end
					|| array[firstHalfIndex] < array[sendHalfIndex])) {
				
				tempArr[j] = array[firstHalfIndex++];
			} else {
				tempArr[j] = array[sendHalfIndex++];
			}
			j++;
		}
		for (int i = 0; i < j; i++) {
			array[start++] = tempArr[i];
		}
		System.out.println(Arrays.toString(array));
	}
}
