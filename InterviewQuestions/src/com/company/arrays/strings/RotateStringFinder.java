/**
 * 
 */
package com.company.arrays.strings;

/**
 * @author rohitdumbre86
 * 
 */
public class RotateStringFinder {

	public boolean ifStringsAreRotated(String a, String b) {
		String a1 = a + a;
		int j = 0;
		int lengthTracker = 0;
		for (int i = 0; i < a1.length(); i++) {
			while (j < b.length() && a1.charAt(i) == b.charAt(j)) {
				lengthTracker++;
				i++;
				j++;

			}

			if (j > 0 && j<b.length()) {
				lengthTracker--;
				j = 0;
			}

		}

		return lengthTracker == b.length();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RotateStringFinder finder = new RotateStringFinder();
		System.out.println(finder.ifStringsAreRotated("waterworld",
				"erworldwat"));
	}

}
