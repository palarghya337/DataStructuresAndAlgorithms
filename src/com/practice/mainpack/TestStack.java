package com.practice.mainpack;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.Stack;

public class TestStack {

	public static void main(String[] args) {
		
		int stackSize = 11;
		Stack<Integer> stack = new Stack<>(stackSize);
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
