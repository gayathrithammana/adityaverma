package binarySearch.educative;

/**
 * Leetcode 153. Find Minimum in Rotated Sorted Array
 * Given Sorted array and is rotated k times, Find K
 * 
 * We need to find the index of minimum element . 
 * The no of times minimum element is moved to the right = no. of rotations
 * 
 * 1. While doing binary search(while(start<end))
 * 
 * 2. check if arr[mid] > arr[mid+1] -> return mid+1
 *             arr[mid-1] > arr[mid] -> return mid
 * 
 * 3. check if arr[start] < arr[mid] search in second half
 *          else search in first half
 *          
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class RotationCount {
	public static int countRotations(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			
			if(mid < end && arr[mid] > arr[mid+1])	//if mid is greater than next element
				return mid + 1;
			if(mid > start && arr[mid-1] > arr[mid])	//if mid is smaller than previos element
				return mid;
			
			if(arr[start] < arr[mid])
				start = mid + 1;	// left side is sorted, so the pivot is on right side
			else
				end = mid - 1;		// right side is sorted, so the pivot is on the left side
		}
		
		return 0;	// the array has not been rotated
	}

	public static void main(String[] args) {
		System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));	//2
		System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));	//5
		System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));	//0
	}
}
