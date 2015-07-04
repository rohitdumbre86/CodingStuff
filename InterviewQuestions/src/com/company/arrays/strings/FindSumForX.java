package com.company.arrays.strings;

import java.util.*;

public class FindSumForX {

	public void printResult(int[] array, int searchForX) {
		Arrays.sort(array);
		int lowerNumber = 0;
		int higherNumber = 0;

		int lIndex = 0;
		int hIndex = array.length - 1;
		int diff = Integer.MAX_VALUE;

		int lowerIndex = 0;
		int higherIndex = array.length - 1;

		while (lIndex <= higherIndex && hIndex > lowerIndex) {
			if (array[lIndex] + array[hIndex] == searchForX) {
				lowerNumber = array[lIndex];
				higherNumber = array[hIndex];
				break;
			}

			int value = Math.abs(searchForX - (array[lIndex] + array[hIndex]));
			if (value < diff) {
				diff = value;
				lowerNumber = array[lIndex];
				higherNumber = array[hIndex];
				lIndex++;
			}
			if (array[lIndex] + array[hIndex] > searchForX) {
				hIndex--;
			} else {
				lIndex++;
			}

		}

		System.out.println("The closest sum to " + searchForX + " is "
				+ lowerNumber + " and " + higherNumber);

	}

	public void printResult(int[] array1, int[] array2, int searchForX) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		int[] array = new int[array1.length + array2.length];

		int k = 0;
		int i = 0;
		int j = 0;

		Arrays.sort(array);

		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				array[k++] = array1[i];
				i++;
			} else if (array2[j] < array1[i]) {
				array[k++] = array2[j];
				j++;
			}else 
			{
				array[k++] = array1[i++];
				array[k++] = array2[j++];
			}

		}

		while (i < array1.length) {
			array[k++] = array1[i++];
		}

		while (j < array2.length) {
			array[k++] = array2[j++];
		}

		printResult(array, searchForX);
	}

	public static void main(String[] args) {
		FindSumForX sumForX = new FindSumForX();
		int[] values = new int[] { 1, 4, 45, 6, 10, -8 };

		int[] value1 = new int[] { 10, 22, 28, 29, 30, 40 };
		int[] value2 = new int[] { 1, 3, 4, 7, 10, 28, 89 };
		sumForX.printResult(values, 16);
		sumForX.printResult(value1, value2, 54);

	}

}