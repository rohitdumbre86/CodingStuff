package com.company.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindNextLexicographicString {

	List<List<Integer>> listOfStrings = new ArrayList<List<Integer>>();

	/**
	 * @param string
	 * @return String lexicographically
	 */
	public String nextLargestCharacter(String string) {

		if (string == null || string.isEmpty())
			return "";

		if (string.length() == 1)
			return string;

		if (checkForImpossibleCases(string)) {
			return "";
		}

		int[] array = convertStringToInt(string);
		array = findLargestCombination(array, array.length - 2,
				array.length - 1);

		return convertIntToString(array);

	}

	/**
	 * @param lexico
	 * @return True if its an invalid case/ false otherwise.
	 */
	private boolean checkForImpossibleCases(String lexico) {
		char[] charArray = lexico.toCharArray();

		if (checkForSameCharacter(charArray)) {
			System.out.println("no answer");
			return true;
		}

		else if (checkForDescendingOrder(charArray)) {
			System.out.println(lexico);
			return true;
		}

		return false;
	}

	/**
	 * This function will check for invalid cases. E.g. Invalid cases can be bbb
	 * 
	 * @param lexico
	 * @return True if an invalid/impossible case is found.
	 */
	private boolean checkForSameCharacter(char[] lexico) {
		int i = 0;

		while (i < lexico.length - 1 && lexico[i] == lexico[i + 1]) {
			i++;
		}

		if (i == lexico.length - 1) {
			return true;
		}

		return false;
	}

	/**
	 * @param lexico
	 * @return True if the string is in descending order , False otherwise.
	 */
	private boolean checkForDescendingOrder(char[] lexico) {
		int i = 0;

		while (i < lexico.length - 1 && lexico[i] >= lexico[i + 1]) {
			i++;
		}

		if (i == lexico.length - 1) {
			return true;
		}

		return false;
	}

	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int[] findLargestCombination(int[] array, int start, int end) {
		
		if (start < 0) {

			List<Integer> greatestList = listOfStrings.get(0);
			int[] greatest = new int[greatestList.size()];
			for (int k = 0; k < greatest.length; k++) {

				greatest[k] = greatestList.get(k);
			}

			return greatest;
		}

		for (int i = 1; i <= (end - start); i++) {
			int[] resultantArray = rotateArrayToLeft(array, start, end, i);

			if (compareArrays(resultantArray, array, start, end)) {

				List<Integer> integers = new ArrayList<Integer>();
				for (int k = 0; k < resultantArray.length; k++) {
					integers.add(resultantArray[k]);
				}

				listOfStrings.add(integers);
			}
		}

		sortTheArrays(listOfStrings);

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

	private void sortTheArrays(List<List<Integer>> listOfStrings) {

		Comparator<List<Integer>> c = new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {

				int[] o1Array = new int[o1.size()];
				int[] o2Array = new int[o2.size()];

				for (int i = 0; i < o1Array.length; i++) {
					o1Array[i] = o1.get(i);
				}

				for (int j = 0; j < o2Array.length; j++) {
					o2Array[j] = o2.get(j);
				}

				int k = 0;

				while (k < o1Array.length && o1Array[k] == o2Array[k]) {
					k++;
				}

				if (k == o1Array.length)
					return 0;

				if (compareArrays(o1Array, o2Array, 0, o1Array.length - 1)) {
					return 1;
				}

				return -1;
			}
		};
		Collections.sort(listOfStrings, c);
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
		System.out.println(soln.nextLargestCharacter("dkhc"));

	}

}
