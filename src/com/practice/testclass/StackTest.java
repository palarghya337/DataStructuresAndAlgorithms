package com.practice.testclass;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.ArrayStack;

public class StackTest {

	public static void main(String[] args) {
		
		int stackSize = 11;
		ArrayStack<Integer> stack = new ArrayStack<>(stackSize);
		Random random = new Random();
		IntStream.generate(() -> random.nextInt(50))
		.distinct().limit(stackSize).forEach(i -> {
			System.out.print(i + " ");
			stack.add(i);
		});
		
		System.out.println("\n" + stack.isEmpty());
		IntStream.range(0, stackSize).forEach(i -> {
			System.out.print(stack.remove() + " ");
		});
		
		System.out.println("\n" + stack.isEmpty());
	}
}
