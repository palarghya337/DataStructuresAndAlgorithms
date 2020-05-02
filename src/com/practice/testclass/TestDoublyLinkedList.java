package com.practice.mainpack;

import java.util.stream.IntStream;

import com.practice.datastructures.linear.DoublyLinkedList;

public class TestDoublyLinkedList {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
		
		long startTime = System.nanoTime();
		IntStream.range(1, 11).forEach(linkedList::add);
		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));
		
		IntStream.range(0, 11)
		.forEach(i -> System.out.print(linkedList.get(i) + ","));
	}

}
