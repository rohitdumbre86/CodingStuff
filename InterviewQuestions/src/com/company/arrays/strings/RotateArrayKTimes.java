package com.company.arrays.strings;

import java.util.Arrays;

public class RotateArrayKTimes {

	public void rotateArrayKTimesToLeft(int[] array, int k) {
		reverse(array, 0, array.length - 1);
		reverse(array, 0, array.length - 1 - k);
		reverse(array, array.length - k, array.length - 1);

	}

	public void rotateArrayKTimesToRight(int[] array, int k) {
		reverse(array, 0, array.length - 1);
		reverse(array, 0, k - 1);
		reverse(array, k, array.length - 1);
	}

	public void reverse(int[] array, int startIndex, int endIndex) {
		while (startIndex < endIndex) {
			int temp = array[endIndex];
			array[endIndex] = array[startIndex];
			array[startIndex] = temp;
			startIndex++;
			endIndex--;
		}

	}

	public static void main(String[] args) {
		int[] arrays = new int[] { 5, 6, 7, 8, 9, 10 };

		int[] others = Arrays.copyOf(arrays, arrays.length);

		System.out.print("Original:");
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}

		RotateArrayKTimes rotatArray = new RotateArrayKTimes();
		rotatArray.rotateArrayKTimesToLeft(arrays, arrays.length-1);

		System.out.println();
		System.out.print("Left:");
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}

		rotatArray.rotateArrayKTimesToRight(others, arrays.length-1);

		System.out.println();
		System.out.print("Right:");
		for (int i = 0; i < others.length; i++) {
			System.out.print(others[i] + " ");
		}
	}
}
