package com.practice.algorithms.searching;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] primeNumbers = {67,71,73,79,83,89,97,101,103,107,109,113};
		Arrays.stream(primeNumbers).forEach(i -> System.out.print((char) i + "=" + i));
		int length = primeNumbers.length - 1;
		int searchItem = 0;
		int isPresent = isNumberPresent(searchItem, primeNumbers, 0, length);
		System.out.println(isPresent);
	}

	private static int isNumberPresent(int searchItem, int[] array, int start, int end) {
		
		int mid = (start + end) / 2;
		if (start != end) {
			if (array[mid] == searchItem) {
				return mid;
			} else if (array[mid] > searchItem) {
				return isNumberPresent(searchItem, array, start, mid);
			} else if (array[mid] < searchItem) {
				return isNumberPresent(searchItem, array, mid + 1, end);
			}
		}
		return -1;
	}
}
