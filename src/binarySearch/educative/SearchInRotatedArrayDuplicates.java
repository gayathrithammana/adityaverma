package binarySearch.educative;

/** 
 * Leetcode 81. Search in Rotated Sorted Array II
 * Given sorted array in ascending order with duplicate values
 *  and rotated at some pivot
 *  
 *  Same as previous problem
 *  except check if start and end  = mid and skip
 *  
 * 1. while doing binary search
 * 	  - if arr[start] = arr[mid] = arr[end]
 * 		start++;
 * 		end--;
 *    - else if left side is sorted arr[start] <= arr[mid]
 *    	- check in first half / second half of left side
 *    - else right side is sorted
 *    	- check in first half / second half of right side
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */

public class SearchInRotatedArrayDuplicates {
	public static int search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(arr[mid] == key)
				return mid;
			
			if((arr[start] == arr[mid]) && (arr[mid] == arr[end])) {//skip
				start++;
				end--;
			}
			else if(arr[start] <= arr[mid]) { //left side is sorted
				if(key >= arr[start] && key < arr[mid])
					end = mid - 1;	//first half of left hand
				else
					start = mid + 1;	//second half of left hand
			} else {	//right side is sorted
				if(key > arr[mid] && key <= arr[end]) 
					start = mid + 1;	//first half of right hand
				else
					end = mid - 1;		//second half of right hand
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[] { 3, 7, 3, 3, 3 }, 7));	//1
	  }
}
