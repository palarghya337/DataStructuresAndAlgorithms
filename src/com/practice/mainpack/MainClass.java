package com.practice.mainpack;

import java.util.stream.IntStream;

import com.practice.datastructures.linkedlist.SinglyLinkedList;

public class MainClass {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		
		long startTime = System.nanoTime();
		IntStream.range(0, 3).forEach(linkedList::add);
		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));
		
		System.out.println(linkedList.size());
		
		startTime = System.nanoTime();
		System.out.println(linkedList.get(2));
		endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(linkedList.remove(1));
		endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime));
		
		System.out.println(linkedList.get(0));
	}

}
