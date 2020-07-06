package com.practice.datastructures.linear;

import java.util.Stack;
import java.util.stream.IntStream;

public class QueueUsingStack {

	public static void main(String[] args) {
		
		QueueDS<Integer> queue = new QueueDS<>();
		IntStream.range(0, 11).forEach(queue::push);
		IntStream.range(0, 11).forEach(i -> System.out.print(queue.pop() + " "));
	}
	private static class QueueDS<T> {
		
		private Stack<T> stack = new Stack<>();
		private Stack<T> stack2 = new Stack<>();
		
		private T push(T item) {
			
			return stack.push(item);
		}
		private T pop() {
			
			if (stack2.isEmpty()) {
				while (!stack.isEmpty()) {
					stack2.push(stack.pop());
				}
			}
			return stack2.pop();
		}
	}
}