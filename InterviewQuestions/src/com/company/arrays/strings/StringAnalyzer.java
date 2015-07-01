package com.company.arrays.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringAnalyzer {

	public Set<String> findStringPermutations(String original, String temp,
			Set<String> values) {
		if (original.isEmpty()) {

			values.add(temp);
			return values;
		} else {
			for (int i = 0; i < original.length(); i++) {

				findStringPermutations(
						original.substring(0, i) + original.substring(i + 1),
						original.charAt(i) + temp, values);
			}

		}
		return values;
	}

	
	private String convertFromLexicoNumber(String value) {
		String lexicoNum = "abcdefghijklmnopqrstuvwxyz";
		String temp = "";
		for (int i = 0; i < value.length(); i++) {
			String str = value.substring(i, i + 1);
			char index = lexicoNum.charAt(Integer.parseInt(str) - 1);
			temp = temp + index;
		}

		return temp;
	}

	public static void main(String args[]) {
		StringAnalyzer stringAnalyzer = new StringAnalyzer();
		Set<String> values = stringAnalyzer.findStringPermutations("dhck", "",
				new HashSet<String>());

		if (values.size() == 1) {
			System.out.println("no answer");
		}

		String[] number = new String[values.size()];
		number = values.toArray(number);
		Arrays.sort(number);
		String lexicoGreater = "";
		for (int i = 0; i < number.length - 1; i++) {
			if (number[i].equals("dhck")) {
				lexicoGreater = number[i + 1];
				break;
			}
		}

		System.out.println(lexicoGreater);
	}
}
