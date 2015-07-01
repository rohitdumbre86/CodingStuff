package com.company.arrays.strings;

import java.util.Scanner;

/**
 * James found a love letter his friend Harry has written for his girlfriend.
 * James is a prankster, so he decides to meddle with the letter. He changes all
 * the words in the letter into palindromes.
 * 
 * To do this, he follows two rules:
 * 
 * He can reduce the value of a letter, e.g. he can change d to c, but he cannot
 * change c to d. In order to form a palindrome, if he has to repeatedly reduce
 * the value of a letter, he can do it until the letter becomes a. Once a letter
 * has been changed to a, it can no longer be changed. Each reduction in the
 * value of any letter is counted as a single operation. Find the minimum number
 * of operations required to convert a given string into a palindrome.
 * 
 * Input Format
 * 
 * The first line contains an integer T, i.e., the number of test cases. The
 * next T lines will contain a string each. The strings do not contain any
 * spaces.
 * 
 * Constraints 1≤T≤10 1≤ length of string ≤104 All characters are lower case
 * English letters.
 * 
 * @author rohitdumbre86
 * 
 */
public class LoveLetterManipulation {
	public boolean isPalindrome(String s) {
		char[] palinds = s.toCharArray();
		int endIndex = palinds.length - 1;

		for (int i = 0; i < palinds.length / 2; i++) {
			if (palinds[i] != palinds[endIndex])
				return false;
			endIndex--;
		}

		return true;

	}

	public int calculatePalindAction(String s) {
		String firstHalf = s.substring(0, s.length() / 2);
		String secondHalf = "";
		if (s.length() % 2 == 0) {
			secondHalf = s.substring(s.length() / 2);
		} else {
			secondHalf = s.substring(s.length() / 2 + 1);
		}

		char[] firstHalves = firstHalf.toCharArray();
		char[] secondHalves = secondHalf.toCharArray();
		int endIndex = firstHalves.length - 1;
		int diff = 0;
		for (int i = 0; i < secondHalves.length; i++) {
			if (firstHalves[endIndex] != secondHalves[i]) {
				diff = diff + Math.abs(firstHalves[endIndex] - secondHalves[i]);
			}

			endIndex--;
		}
		return diff;
	}

	public int loveLetterManipulation(String s) {
		if (isPalindrome(s))
			return 0;

		else
			return calculatePalindAction(s);
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(in.nextLine());
		int start = 1;
		LoveLetterManipulation s = new LoveLetterManipulation();
		while (in.hasNext() && start <= numberOfTestCases) {
			String string = in.nextLine();
			System.out.println(s.loveLetterManipulation(string));
		}

	}
}
