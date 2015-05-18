package com.company.recursion;

import java.util.Iterator;
import java.util.Stack;

public class StepsAnalyzer {

	public int TOTAL_SIZE = 8;
	public static int totalNumberOfSteps = 1;

	public void numberOfWaysToAnalyzeSteps(int numberOfSteps,
			Stack<Integer> steps) {
		if (numberOfSteps == 0) {

			printSteps(steps);
			steps.pop();
			return;
		}

		int step3 = numberOfSteps - 3;
		int step2 = numberOfSteps - 2;
		int step1 = numberOfSteps - 1;

		if (step3 >= 0) {
			steps.push(3);
			numberOfWaysToAnalyzeSteps(step3, steps);
		}
		if (step2 >= 0) {
			steps.push(2);
			numberOfWaysToAnalyzeSteps(step2, steps);
		}
		if (step1 >= 0) {
			steps.push(1);
			numberOfWaysToAnalyzeSteps(step1, steps);
		}

		if (!steps.isEmpty()) {
			steps.pop();

		}

	}

	public int numberOfStepsInDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = numberOfStepsInDP(n - 1, map)
					+ numberOfStepsInDP(n - 2, map)
					+ numberOfStepsInDP(n - 3, map);

		}

		return map[n];
	}

	public void printSteps(Stack<Integer> steps) {
		StringBuilder strBuilder = new StringBuilder();
		totalNumberOfSteps++;
		strBuilder.append(TOTAL_SIZE);
		strBuilder.append("=");

		Iterator<Integer> numberOfSteps = steps.iterator();

		while (numberOfSteps.hasNext()) {
			Integer i = numberOfSteps.next();
			strBuilder.append(i);
			strBuilder.append("+");
		}
		String string = strBuilder.toString();
		System.out.println(string.subSequence(0, string.length() - 1));

	}

	public static void main(String[] args) {
		StepsAnalyzer steps = new StepsAnalyzer();
		steps.numberOfWaysToAnalyzeSteps(8, new Stack<Integer>());
		System.out.println("Total Number of steps " + totalNumberOfSteps);
		int[] maps = new int[200];
		for(int i =0; i<200;i++)
		{
			maps[i] = -1;
		}
		System.out.println(steps.numberOfStepsInDP(8, maps));

	}

}
