package com.company.stacks.queues;

import java.util.Stack;

public class SortAStack {
	public Stack<Integer> sortedStack;

	public SortAStack() {
		sortedStack = new Stack<Integer>();
	}

	public void sortStack() {
		Stack<Integer> bufferStack = new Stack<Integer>();
		while (!sortedStack.isEmpty()) {
			int value = sortedStack.pop();
			while (!bufferStack.isEmpty()) {
				if (bufferStack.peek() <= value) {
					break;
				} else {
					sortedStack.push(bufferStack.pop());
				}
			}

			bufferStack.push(value);

		}

		sortedStack = bufferStack;
	}

	public void push(int value) {
		sortedStack.push(value);
	}

	public int pop() {
		if (sortedStack.isEmpty()) {
			return -1;
		}

		return sortedStack.pop();
	}

	public int peek() {
		return sortedStack.peek();
	}

	public void printStack() {
		for (Integer i : sortedStack) {
			System.out.print(i + " ");
		}

	}

	public static void main(String args[]) {
		SortAStack sort = new SortAStack();
		sort.push(40);
		sort.push(11);
		sort.push(29);
		sort.push(34);
		sort.sortStack();

		sort.printStack();
	}

}
