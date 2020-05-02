package com.practice.testclass;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.LinkedQueue;

public class QueueTest {

	public static void main(String[] args) {
		
		int maxSize = 10;
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		Random random = new Random();
		IntStream.generate(() -> random.nextInt(50))
			.distinct()
			.limit(maxSize)
			.forEach(i -> {
				System.out.print(i + " ");
				queue.add(i);
			});
		
		System.out.println("\nQueue size: " + queue.size());
		
		IntStream.range(0, maxSize)
			.forEach(i -> System.out.print(queue.poll() + " "));
		System.out.println("\nQueue size: " + queue.size());
	}
}
