package com.company.arrays.strings;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner inputMatrix = new Scanner(System.in);
		int n = inputMatrix.nextInt();
		char[][] matrix = new char[n][n];
		for (int i = 0; i < n; i++) {

			String s1 = String.valueOf(inputMatrix.nextBigInteger());
			for (int j = 0; j < s1.length(); j++) {
				;
				matrix[i][j] = s1.charAt(j);
			}
		}

		Solution cavityMarker = new Solution();
		matrix = cavityMarker.markCavity(matrix);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public char[][] markCavity(char[][] matrix) {
		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix.length - 1; j++) {
				int edge1 = matrix[i - 1][j];
				int edge2 = matrix[i][j + 1];
				int edge3 = matrix[i][j - 1];
				int edge4 = matrix[i + 1][j];

				int cavity = matrix[i][j];
				if (cavity > edge1 && cavity > edge2 && cavity > edge3
						&& cavity > edge4)
					matrix[i][j] = 'X';

			}

		}

		return matrix;

	}

}
