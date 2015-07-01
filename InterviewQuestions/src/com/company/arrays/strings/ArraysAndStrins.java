package com.company.arrays.strings;

import java.util.ArrayList;
import java.util.List;

public class ArraysAndStrins {

	public boolean tellIfUnique(final String val) {
		String temp = "";

		for (int i = 0; i < val.length(); i++) {
			char ch = val.charAt(i);
			if (temp.indexOf(ch) == -1) {
				temp = temp + ch;

			} else if (ch != ' ') {
				return false;
			}

		}

		return true;
	}

	public String replaseSpaces(char[] str, int length) {
		int spaceCount = 0, newLength = 0, i = 0;

		for (i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}

		newLength = length + (spaceCount * 2);
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return new String(str);
	}

	/**
	 * Coding Question : Question 5
	 * 
	 * @param str
	 *            String to be compressed.
	 * @return Compressed string which contains number
	 */
	public String compressString(String str) {

		String temp = "";
		int k = 0;
		int i = 0;
		String originalString = str;
		while (i < str.length()) {

			int count = returnCount(str);
			temp = temp + str.charAt(0) + String.valueOf(count);

			str = str.substring(count);
			System.out.println();
		}

		if (originalString.length() * 2 == temp.length())
			return originalString;

		return temp;

	}

	public int returnCount(String str) {
		int count = 1;
		int i = 0;
		while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
			i++;
			++count;
		}

		return count;
	}

	/**
	 * Returns true, if str2 is rotated for str1. Question 8
	 * @param str1
	 * @param str2 Possibly rotated string
	 * @return
	 */
	public boolean oneStirngRotationOfAnother(String str1, String str2) {
		if (str1.equals(str2))
			return false;

		char ch = str1.charAt(0);
		int k = str2.indexOf(ch);
		int startIndex = k;
		int i = 0;
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		if (k + 1 == char2.length) {
			k = 0;
		} else {
			k = k + 1;
		}
		i = i + 1;
		while (k != startIndex && char1[i] == char2[k]) {
			if (k + 1 == char2.length) {
				k = 0;
				i = i+1;
			} else {
				i++;
				k++;
			}
		}
		
		if(k!=startIndex) return false;
		
		return true;
	}

	public static void main(String[] args) {
		ArraysAndStrins str = new ArraysAndStrins();
		String string = "Ab cd      ";
		System.out.println(str.replaseSpaces(string.toCharArray(), string
				.trim().length()));

		System.out.println(str.compressString("abcd"));
		System.out.println(str.oneStirngRotationOfAnother("waterbottle", "terbwottlewa"));
	}

}
