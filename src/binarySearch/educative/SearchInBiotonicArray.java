package binarySearch.educative;

/**
 * 1. Find max index in biotonic array
 * 2. apply binary search on 0 -> maxIndex 
 * 				      and maxIndex+1 -> len - 1  
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */

public class SearchInBiotonicArray {
	
	private static int search(int[] arr, int key) {
		int maxIndex = findMaxIndex(arr);
		int keyIndex = binarySearch(arr, key, 0, maxIndex);
		if(keyIndex != -1)
			return keyIndex;
		return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
	}
	
	private static int findMaxIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] > arr[mid + 1])
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}
	
	private static int binarySearch(int[] arr, int key, int start, int end) {
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(key == arr[mid])
				return mid;
			
			if(arr[start] < arr[end]) {	//ascending order
				if(key < arr[mid])
					end = mid - 1;	//search in first half
				else
					start = mid + 1;	//search in second half
			} else {				//descending order
				if(key > arr[mid])
					end = mid - 1;	//search in first half
				else
					start = mid + 1;	//search in second half
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));	//3
		System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));	//1
		System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));	//3
		System.out.println(search(new int[] { 10, 9, 8 }, 10));		//0
	}
}
