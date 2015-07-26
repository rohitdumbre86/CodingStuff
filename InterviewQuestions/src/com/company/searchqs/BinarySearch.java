package com.company.searchqs;

public class BinarySearch {

	public int searchOnEmpty(String[] searches, String searchString, int start,
			int end) {

		if (start < end) {
			int mid = start + (end - start) / 2;

			if (searches[mid] == searchString)
				return mid;

			int left = mid - 1;
			int right = mid + 1;

			while (true) {

				if (right > end && left < start)
					return -1;

				if (right <= end && !searches[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= start && !searches[left].isEmpty()) {
					mid = left;
					break;
				}

				left--;
				right++;

			}

			if (searches[mid].compareTo(searchString) < 0) {
				return searchOnEmpty(searches, searchString, mid + 1, end);
			} else if (searches[mid].compareTo(searchString) > 0) {
				return searchOnEmpty(searches, searchString, start, mid - 1);
			}

			return mid;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		String[] searchString = new String[] { "at", "", "", "", "ball", "",
				"", "car", "", "", "dad", "", "", "lad" };
		System.out.println(search.searchOnEmpty(searchString, "lad", 0,
				searchString.length - 1));
	}
}
