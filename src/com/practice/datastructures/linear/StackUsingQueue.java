package com.practice.datastructures.linear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class StackUsingQueue {

	public static void main(String[] args) {
		
		StackDS<Integer> queue = new StackDS<>();
		IntStream.range(0, 11).forEach(queue::push);
		IntStream.range(0, 5).forEach(i -> System.out.print(queue.pop() + " "));
		queue.push(12);
		IntStream.range(0, 6).forEach(i -> System.out.print(queue.pop() + " "));
	}
	private static class StackDS<T> {
		
		private Queue<T> queue = new LinkedList<>();
		private Queue<T> queue2 = new LinkedList<>();
		
		public boolean push(T item) {
			return queue.add(item);
		}
		public T pop() {
			
			while (queue.size() != 1) {
				queue2.add(queue.poll());
			}
			T item = queue.poll();
			Queue<T> temp = queue;
			queue = queue2;
			queue2 = temp;
			return item;
		}
	}
}