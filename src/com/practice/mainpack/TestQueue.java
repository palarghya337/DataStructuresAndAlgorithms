package com.practice.mainpack;

import java.util.Random;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.Queue;

public class TestQueue {

	public static void main(String[] args) {
		
		int itemProducingSize = 20;
		Queue<Integer> stack = new Queue<>();
		Random random = new Random();
		
		new Thread(() -> {
			
			IntStream.generate(() -> random.nextInt(50))
			.distinct().limit(itemProducingSize).forEach(i -> {
				
				synchronized(stack) {
					if (stack.add(i)) {
						System.out.println(i + "-> added");
					}
				}
				sleep(500);
			});
		}).start();
		System.out.println();
		
		new Thread(() -> {
			
			boolean isStop = true;
			while (isStop) {
				
				sleep(1000);
				Object obj = null;;
				synchronized(stack) {
					
					obj = stack.remove();
					System.out.println(stack.isEmpty());
				}
				if (obj != null) {
					System.out.println(obj + "-> removed");
				}
				if (stack.isEmpty()) {
					isStop = false;
				}
			}
		}).start();
	}

	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
