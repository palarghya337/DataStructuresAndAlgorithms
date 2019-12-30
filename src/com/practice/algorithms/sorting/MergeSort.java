package com.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort {

	public static void main(String[] args) {

		int arraySize = 10;
		Random random = new Random();
		int[] array = IntStream.generate(() -> random.nextInt(50))
				.distinct().limit(arraySize).toArray();
		System.out.println(Arrays.toString(array));
		sort(array, 0, arraySize - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void sort(int[] array, int start, int end) {
		
		if (start < end) {
			int mid = (start + end) / 2;
			sort(array, start, mid);
			sort(array, mid+1, end);
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
	}
}
