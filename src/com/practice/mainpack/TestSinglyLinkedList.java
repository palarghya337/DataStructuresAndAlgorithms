package com.practice.mainpack;

import java.util.stream.IntStream;

import com.practice.datastructures.linear.SinglyLinkedList;

public class TestSinglyLinkedList {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

		long startTime = System.nanoTime();
		IntStream.range(1, 11).forEach(linkedList::add);
		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));

		System.out.println("Size: " + linkedList.size());


		startTime = System.nanoTime();
		System.out.println("get(0): " +
				linkedList.get(0));
		endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));

		startTime = System.nanoTime();
		System.out.println("remove(1): " + linkedList.remove(2));
		endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));


		System.out.println("get(0): " + linkedList.get(0));

		linkedList.reverse();
		IntStream.range(0, linkedList.size())
		.forEach(index -> System.out.print(linkedList.get(index) + ","));
	}

}
