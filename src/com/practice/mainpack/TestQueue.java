package com.practice.mainpack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.practice.datastructures.linear.Queue;

public class TestQueue {

	private static boolean isStop = false;
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<>();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(() -> produce(queue));
		service.execute(() -> consume(queue));
		service.shutdown();
	}

	private static void consume(Queue<Integer> queue) {
		
		int count = 0;
		while (!isStop) {
			
			sleep(500);
			Integer obj = null;
			synchronized(queue) {

				obj = queue.remove();
				if (count == 3) {
					count = 0;
					queue.notify();
				}
				count++;
			}
			if (obj != null) {
				System.out.println(obj + "-> removed");
				isStop = obj == 19;
			}
		}
	}

	private static void produce(Queue<Integer> queue) {

		IntStream.range(0, 20).forEach(i -> {
			
			synchronized(queue) {
				if (!queue.add(i)) {
					try {
						System.out.println(i + " is waiting as queue became empty.");
						queue.wait();
						queue.add(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(i + "-> added");
				queue.notify();
				sleep(100);
			}
		});
		isStop = true;
	}

	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
