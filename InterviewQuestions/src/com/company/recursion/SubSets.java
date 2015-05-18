package com.company.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {

	ArrayList<ArrayList<Integer>> getSubsets(List<Integer> set) {
		
		
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allSubsets.add(subset);
		}

		return allSubsets;

	}

	ArrayList<Integer> convertIntToSet(int x, List<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}

		return subset;

	}

	public static void main(String[] args) {

		SubSets sets = new SubSets();
		List<Integer> arrays = new ArrayList<Integer>();
		arrays.add(3);
		arrays.add(5);
		arrays.add(2);
		arrays.add(4);
       sets.getSubsets(arrays);
	}

}
