package binarySearch.educative;
/**
 * Leetcode 702: Search in a Sorted Array of Unknown Size
 * 
 * 1.start = 0, end = 1
 * 2.keep increasing bounds exponentially until num[end] < key
 * 3.apply binary search 
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */

public class SearchInInfiniteArray {
	public static int search(ArrayReader reader, int key) {
		int start = 0;
		int end = 1;
		while (reader.get(end) < key) {
			int newStart = end + 1;
			end += (end - start + 1) * 2;
			start = newStart;
		}

		return search(reader, key, start, end);
	}

	// binary search
	private static int search(ArrayReader reader, int key, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < reader.get(mid)) {
				end = mid - 1;
			} else if (key > reader.get(mid)) {
				start = mid + 1;
			} else { // found the key
				return mid;
			}
		}

		return -1;
	}
}

class ArrayReader {
	int[] arr;

	ArrayReader(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		if (index >= arr.length)
			return Integer.MAX_VALUE;
		return arr[index];
	}
}
