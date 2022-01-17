package binarySearch.educative;
/**
 * Leetcode 702: Search in a Sorted Array of Unknown Size
 * 
 * 1.apply binary search 
 * 2.find diff of key with arr[start], arr[end]
 * 3. return min diff element
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */

public class MinimumDifferenceElement {
	public static int searchMinDiffElement(int[] arr, int key) {
		int n = arr.length;
		if(key < arr[0])
			return arr[0];
		if(key > arr[n - 1])
			return arr[n-1];
		
		int start = 0;
		int end = n - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(key == arr[mid])
				return arr[mid];
			
			if(key < arr[mid])
				end = mid - 1;	//search in first half
			else if(key > arr[mid])
				start = mid + 1;	//search in second half
		}
		
		if((arr[start] - key) < (key - arr[end]))
			return arr[start];
		
		return arr[end];
	}

	public static void main(String[] args) {
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
		System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
	}
}
