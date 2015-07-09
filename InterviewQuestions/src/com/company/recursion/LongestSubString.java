package com.company.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestSubString {

	public void getStrings(String value) {
		int startIndex = 0;
		int length = value.length();
		List<String> values = new ArrayList<String>();
		int count = 1;
		String temp = "";
		for (int i = startIndex; i < length; i++) {

			char c = value.charAt(i);
			if (temp.indexOf(c) >= 0) {
				temp = temp + c;
			} else if (temp.indexOf(c) < 0 && count + 1 <= 3) {
				temp = temp + c;
				count = count + 1;
			} else {
				startIndex = startIndex + 1;
				i = startIndex;
				values.add(temp);
				count = 1;
				temp = "";
			}
			if (i == length - 1) {
				values.add(temp);
			}
		}
		int maxValue = 2;
		temp = "";
		for (String s : values) {
			if (maxValue < s.length()) {
				maxValue = s.length();
				temp = s;
			}
		}

		System.out.println(temp);

	}

	public static void main(String[] args) {
		LongestSubString sbs = new LongestSubString();
		sbs.getStrings("abababcdcdeeeeeeeeef");
	}

}
