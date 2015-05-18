package com.company.recursion;

public class CombinationsOfStrings {
	public void makeCombinations(String prefix, String text) {

		if (text.length() > 0) {
			System.out.println(text);
			makeCombinations(prefix + text.charAt(0), text.substring(1));
			makeCombinations(prefix, text.substring(1));

		}

	}
	
	public static void main(String[] args)
	{
		CombinationsOfStrings combo = new CombinationsOfStrings();
		combo.makeCombinations("", "abc");
	}

}
