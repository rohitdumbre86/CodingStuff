package com.company.arrays.strings;

import java.util.*;

public class FindLongestIncreasingSubsequence {

	public void longestIncreasingSubsequence(int[] numbers,
			List<ArrayList<Integer>> sequences, int index) {
		if (index == numbers.length)
			return;

		Integer number = numbers[index];

		ArrayList<Integer> sequence = null;

		for (int i = 0; i < index; i++) {
			if (numbers[i] < number) {
				sequence = maxSequence(sequence, sequences.get(i));
			}
		}

		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(number);

		if (sequence != null) {
			sequences.add(sequence);
		} else {
			sequences.add(seq);
		}			
		longestIncreasingSubsequence(numbers, sequences, index + 1);

	}

	public ArrayList<Integer> maxSequence(ArrayList<Integer> seq1,
			ArrayList<Integer> seq2) {
		if (seq1 == null)
			return seq2;
		if (seq2 == null)
			return seq1;

		return seq1.size() > seq2.size() ? seq1 : seq2;

	}

	public void longestIncreasingSubsequence(int[] numbers) {
		List<ArrayList<Integer>> sequences = new ArrayList<ArrayList<Integer>>();

		longestIncreasingSubsequence(numbers, sequences, 0);

		int maxLength = -1;
		List<Integer> maxSequence = new ArrayList<Integer>();

		for (List<Integer> sequence : sequences) {
			int length = sequence.size();
			if (length > maxLength) {
				maxSequence = sequence;
			}

		}

		for (int i : maxSequence) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 4, 1, 3, 5, 6, 2, 3 };

		FindLongestIncreasingSubsequence sequence = new FindLongestIncreasingSubsequence();
		sequence.longestIncreasingSubsequence(numbers);
	}
}
