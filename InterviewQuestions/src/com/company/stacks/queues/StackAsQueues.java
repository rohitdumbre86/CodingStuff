package com.company.stacks.queues;

import java.util.*;

public class StackAsQueues {

	private final Stack<Integer> stack1;
	private final Stack<Integer> stack2;

	public StackAsQueues() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void enQueue(int value) {
		stack1.push(value);
	}

	private void shiftStacks() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}

	public int deQueue() throws Exception {
		shiftStacks();
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}

		throw new Exception("The Queue is empty");
	}

	public void printQueue() {
		shiftStacks();
		for (Integer i : stack2) {
			System.out.print(" " + i);
		}

	}
	

	public static void main(String args[]) throws Exception {
		final StackAsQueues queue = new StackAsQueues();
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.deQueue();
		queue.printQueue();
	}

}