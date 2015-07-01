package com.company.arrays.strings;

import java.util.Scanner;

public class ChocolateWrapper {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		for (int i = 0; i < 1; i++) {
			System.out.println(Solve(10, 2, 2));
		}
	}

	private static int Solve(int N, int C, int M) {

		if (N < 0)
			return 0;

		int numberOfChocs = N / C;
		if (numberOfChocs < M) {
			return numberOfChocs;
		} else if (numberOfChocs == M) {
			return numberOfChocs + 1;
		} else {

			return numberOfChocs + getFreeChocolates(numberOfChocs, M, 0);
		}
	}

	public static int getFreeChocolates(int currentChocs, int tradeAmount,
			int remainingWrapper) {

		if (currentChocs + remainingWrapper < tradeAmount)
			return 0;

		int wrapperToTrade = 1;
		for (int i = 1; i <= currentChocs; i = i * tradeAmount) {
			wrapperToTrade = i;
		}

		int freeChocs = (wrapperToTrade + remainingWrapper) / tradeAmount;
		remainingWrapper = currentChocs - wrapperToTrade;

		return freeChocs
				+ getFreeChocolates(freeChocs, tradeAmount, remainingWrapper);

	}

}
