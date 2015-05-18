package com.company.recursion;

public class PermutationsOfString {
	
	
	public void printAllPermutations(String original, String temp)
	{
		if(original.isEmpty())
		{
			System.out.println(temp);
		}
		
		for(int i=0;i<original.length();i++)
		{
			 
			printAllPermutations(original.substring(0, i) + original.substring(i+1),temp+original.charAt(i));
		}
		
	}

	public static void main(String[] args) {

		PermutationsOfString printPermuts = new PermutationsOfString();
		printPermuts.printAllPermutations("abc", "");
	}

}
