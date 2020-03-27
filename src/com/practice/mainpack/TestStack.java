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
		System.out.println();
		
		IntStream.range(0, 10).forEach(i -> {
			System.out.print(stack.remove() + " ");
		});
	}
}
