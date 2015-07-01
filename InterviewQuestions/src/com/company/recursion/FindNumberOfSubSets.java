package com.company.recursion;

import java.util.*;

public class FindNumberOfSubSets {

	public List<List<String>> findSubSets(List<String> sets,
			List<List<String>> listOfSubsets, int index) {
		if (sets.size() == index) {
			List<String> subset = new ArrayList<String>();
			listOfSubsets.add(subset);
		} else {
			List<List<String>> items = findSubSets(sets, listOfSubsets,
					index + 1);
			String item = sets.get(index);

			List<List<String>> moreSubsets = new ArrayList<List<String>>();

			for (List<String> subsets : items) {
				List<String> value = new ArrayList<String>();
				value.add(item);
				value.addAll(subsets);
				moreSubsets.add(value);
			}

			items.addAll(moreSubsets);

		}
		return listOfSubsets;
	}

	public static void main(String[] args) {
		final FindNumberOfSubSets subSet = new FindNumberOfSubSets();
		final List<String> set = new ArrayList<String>();
		set.add("3");
		set.add("2");
		set.add("5");
		set.add("1");

		List<List<String>> subsList = new ArrayList<List<String>>();

		List<List<String>> subSets = subSet.findSubSets(set, subsList, 0);

		for (List<String> sets : subSets) {
			for (String s : sets) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

}