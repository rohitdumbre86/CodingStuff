package com.company.recursion;

public class FindLongestPalindromicSubsequence {
	public void findPalindromicSubsequence(String s) {
		int[][] traversalArray = populateTraversalArray(s);
		printArray(traversalArray);
		String palindrome = getLongestPalindrome(traversalArray,
				s.toCharArray());
		System.out.println("Longest Subsequence Palindrome: " + palindrome);
	}

	private void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");

			}
			System.out.println();
		}

	}

	private int[][] populateTraversalArray(String s) {
		int[][] travers = new int[s.length()][s.length()];
		char[] strings = s.toCharArray();

		for (int i = 0; i < strings.length; i++) {
			travers[i][i] = 1;
		}

		int length = 0;
		while (travers[0][travers.length - 1] == 0) {
			length = length + 1;

			for (int i = 0, j = 0; i <= strings.length - 1 - length; i++) {
				j = i + length;
				if (strings[i] == strings[j]) {
					travers[i][j] = travers[i + 1][j - 1] + 2;
				} else {
					travers[i][j] = Math.max(travers[i][j - 1],
							travers[i + 1][j]);
				}
			}

		}
		return travers;
	}

	private String getLongestPalindrome(int[][] travers, char[] string) {
		int maxLengthOfPalindrome = travers[0][travers.length - 1];
		char[] palindrome = new char[maxLengthOfPalindrome];

		int i = 0;
		int j = travers.length - 1;

		int boundLower = 0;
		int boundHigher = maxLengthOfPalindrome - 1;

		if (travers[i][j] <= 1)
			return "" + string[j];

		while (boundLower <= boundHigher) {

			while (travers[i][j] == Math.max(travers[i][j - 1],
					travers[i + 1][j])) {
				if (travers[i][j] == travers[i][j - 1]) {
					j = j - 1;
				} else {
					i = i + 1;
				}
			}

			if (travers[i][j] == travers[i + 1][j - 1] + 2) {
				palindrome[boundLower] = string[j];
				palindrome[boundHigher] = string[j];
				i = i + 1;
				j = j - 1;

			}

			if (travers[i][j] == 1 && boundLower == boundHigher) {
				palindrome[boundLower] = string[j];
			}

			boundLower++;
			boundHigher--;

		}

		return new String(palindrome);
	}

	public static void main(String[] args) {
		FindLongestPalindromicSubsequence subsequence = new FindLongestPalindromicSubsequence();
		subsequence.findPalindromicSubsequence("ABCD");
	}

}
