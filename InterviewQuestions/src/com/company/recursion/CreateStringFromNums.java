package com.company.recursion;


public class CreateStringFromNums {

	public static int RECURS_CALLS = 0;

	public boolean pairsAreSatisfied(String magic, int noOfPairs) {
		int currentNoOfPairs = 0;

		char[] magicChars = magic.toCharArray();

		for (int i = 0; i < magicChars.length; i++) {
			if (magicChars[i] == 'b')
				continue;

			for (int j = i + 1; j < magicChars.length; j++) {
				if (magicChars[j] == 'a')
					continue;
				currentNoOfPairs++;
			}

		}

		return currentNoOfPairs == noOfPairs;
	}

	public String createString(String initialString, int length, int pairs) {
		if (pairsAreSatisfied(initialString, pairs)
				&& initialString.length() == length) {
			return initialString;
		} else if (initialString.length() == length) {

			return "";
		}
		String stringOfB = createString("b" + initialString, length, pairs);


		String stringOfA = createString("a" + initialString, length, pairs);


		if (!stringOfB.isEmpty())
			return stringOfB;

		return stringOfA;
	}
	
	 public String createString(int N, int K)
	  {
	     if(N <=0 || K < 0)
	         return "";
	  
	     return createString("b",N, K);
	  }

	public static void main(String[] args) {
		CreateStringFromNums strings = new CreateStringFromNums();
		System.out.println(strings.createString(2, 0));

	}

}
