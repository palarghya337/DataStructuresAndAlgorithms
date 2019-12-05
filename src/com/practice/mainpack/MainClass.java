package com.practice.mainpack;

import java.util.stream.IntStream;

import com.practice.datastructures.linkedlist.SinglyLinkedList;

public class MainClass {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		IntStream.range(0, 50).forEach(linkedList::add);
		System.out.println(linkedList.size());
	}

}
