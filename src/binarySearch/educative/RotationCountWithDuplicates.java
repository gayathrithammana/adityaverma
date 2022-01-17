package binarySearch.educative;

/**
 * Leetcode 154. Find Minimum in Rotated Sorted Array II
 * Given Sorted array and is rotated k times, Find K or minium element
 * 
 * We need to find the index of minimum element . 
 * The no of times minimum element is moved to the right = no. of rotations
 * 
 * 1. While doing binary search(while(start<end))
 * 
 * 2. check if arr[mid] > arr[mid+1] -> return mid+1
 *             arr[mid-1] > arr[mid] -> return mid
 * 
 * 3. check if arr[start] = arr[mid] = arr[end]
 *             if(arr[start + 1] < arr[start]) -> return start+1;
 * 			   if(arr[end] < arr[end-1]) -> return end;
 * 			   start++;
 * 		       end--; 
 * else if arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])search in second half
 *          else search in first half
 *          
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class RotationCountWithDuplicates {
	public static int countRotations(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			
			if(mid < end && arr[mid] > arr[mid+1])	//if mid is greater than next element
				return mid + 1;
			if(mid > start && arr[mid-1] > arr[mid])	//if mid is smaller than previos element
				return mid;
			
			// this is the only difference from the previous solution
		      // if numbers at indices start, mid, and end are same, we can't choose a side
		      // the best we can do is to skip one number from both ends if they are not the smallest number
			if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
				
				if(arr[start + 1] < arr[start])
					return start + 1;
				
				if(arr[end] < arr[end-1])
					return end;
				
				start++;
				end--;
			} else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]))
				start = mid + 1;	// left side is sorted, so the pivot is on right side
			else
				end = mid - 1;		// right side is sorted, so the pivot is on the left side
		}
		
		return 0;	// the array has not been rotated
	}

	public static void main(String[] args) {
		System.out.println(countRotations(new int[] { 3, 3, 7, 3 }));	//3
	}
}
