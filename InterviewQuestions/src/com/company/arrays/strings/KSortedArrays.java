package com.company.arrays.strings;

import java.util.PriorityQueue;

public class KSortedArrays implements Comparable<KSortedArrays> {

	public int[] array;
	public int startIndex;

	public KSortedArrays(int[] arrays) {
		array = arrays;
		startIndex = 0;
	}

	public boolean isEmpty() {
		return startIndex == array.length;
	}

	public int peek() {
		return array[startIndex];
	}

	public int getNextInt() {
		return array[startIndex++];
	}

	@Override
	public int compareTo(KSortedArrays o) {
		return new Integer(peek()).compareTo(o.peek());
	}

	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 6, 8, 9, 12, 14, 16 };
		int[] arr2 = { 3, 6, 7, 9, 22, 25, 28 };
		int[] arr3 = { 2, 5, 7, 8, 10, 11, 16 };
		int[] arr4 = { 4, 8, 23, 26, 28 };
		
		int[] result = mergeNArrays(new int[][]{arr1,arr2,arr3,arr4});
		for(int i: result)
		{
			System.out.print(i+" ");
		}

	}

	private static int[] mergeNArrays(int[][] sortedArray) {
		PriorityQueue<KSortedArrays> heap = new PriorityQueue<KSortedArrays>();
        int totalLength = 0;
		for(int i=0; i<sortedArray.length;i++)
        {
        	totalLength += sortedArray[i].length;
        	heap.add(new KSortedArrays(sortedArray[i]));
        }
		
		int[] result = new int[totalLength];
		int index = 0;
		while(!heap.isEmpty())
		{
			KSortedArrays KSortedArray = heap.poll();
			result[index++] = KSortedArray.getNextInt();
			if(KSortedArray.isEmpty())
				continue;
			heap.add(KSortedArray);
		}
		return result;
	}

}
