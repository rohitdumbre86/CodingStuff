package com.company.arrays.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SteppingStones {

	public Set<Integer> steppingStones(int diffA,int diffB, int maxStone) {

	    Set<Integer> values = new TreeSet<Integer>();
	    
	    values.add(diffA*(maxStone-1));
	    values.add(diffB*(maxStone-1));
	    
	    for(int i=1;i<=maxStone-1;i++)
	    {
	       int valueA = diffA*i+diffB*(maxStone-1-i);
	       int valueB = diffB*i+diffB*(maxStone-1-i);
	       values.add(valueA);
	       values.add(valueB);	    	
	    } 	
	    
	    
		return values;

	}

	
	public static void main(String[] args) {

		// Scanner scan = new Scanner(System.in);
		// int testCase = scan.nextInt();

		SteppingStones steppingStones = new SteppingStones();
		Set<Integer> values = steppingStones.steppingStones(1, 2, 3);
		
		for (Integer value : values) {
			System.out.print(value + " ");
		}

		List<Integer> value1 = new ArrayList<Integer>();
		Set<Double> topics = new TreeSet<Double>();
	}

}
