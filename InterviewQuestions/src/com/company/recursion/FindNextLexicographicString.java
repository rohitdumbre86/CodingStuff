package com.company.recursion;

import java.util.Arrays;

public class FindNextLexicographicString {

	public String nextLargestCharacter(String string) {
		if (string == null || string.isEmpty())
			return "";

		if (string.length() == 1)
			return string;

		int i = 0;
		char[] charArray = string.toCharArray();
		while (i < charArray.length-1 && charArray[i] >= charArray[i + 1]) {
			i++;
		}

		if (i == charArray.length-1)
			return "no answer";

		int[] array = convertStringToInt(string);
		array = findLargestCombination(array, array.length - 2,
				array.length - 1);

		return convertIntToString(array);

	}

	public int[] findLargestCombination(int[] array, int start, int end) {
		if (start < 0) {
			return array;
		}

		for (int i = 1; i <= (end - start); i++) {
			int[] resultantArray = rotateArrayToLeft(array, start, end, i);
			if (compareArrays(resultantArray, array, start, end)) {
				return resultantArray;
			}
		}

		return findLargestCombination(array, --start, end);
	}

	public int[] convertStringToInt(String string) {
		int[] array = new int[string.length()];
		char[] charArray = string.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			int value = (int) (charArray[i] - 'a');
			array[i] = value;
		}

		return array;
	}

	public String convertIntToString(int[] array) {
		String temp = "abcdefghijklmnopqrstuvwxyz";

		String rotatedString = "";
		for (int i = 0; i < array.length; i++) {

			rotatedString = rotatedString + temp.charAt(array[i]);
		}
		return rotatedString;
	}

	public int[] rotateArrayToLeft(int[] array, int start, int end,
			int numberOfTimes) {
		if (start < 0)
			return array;

		int[] resultantArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			resultantArray[i] = array[i];
		}

		int startRotation = 1;
		while (startRotation <= numberOfTimes) {

			for (int i = end; i > start; i--) {

				int temp = resultantArray[i];
				resultantArray[i] = resultantArray[i - 1];
				resultantArray[i - 1] = temp;
			}

			startRotation++;
		}

		return resultantArray;
	}

	public boolean compareArrays(int[] resultantArray, int[] array, int start,
			int end) {
		for (int i = 0; i <= array.length - 1; i++) {
			int value1 = resultantArray[i];
			int value2 = array[i];
			if (value1 > value2)
				return true;
			else if (value2 > value1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNextLexicographicString soln = new FindNextLexicographicString();
		System.out.println(soln.nextLargestCharacter("prpl"));
		

	}

}
