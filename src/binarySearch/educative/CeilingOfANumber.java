package binarySearch.educative;

/** 
 * Find ceiling of a number, index of number <= key, for a given sorted array
 * or
 * Find Smallest element greater than or equal to key
 * 1. apply binary search
 * 2. return start
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class CeilingOfANumber {

	public static int searchCeilingOfANumber(int[] arr, int key) {
		if(key > arr[arr.length - 1])
			return -1;
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(key == arr[mid])
				return mid;
			
			if(key < arr[mid])
				end = mid - 1;	//search in first half
			else
				start = mid + 1;	//search in second half
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));	//1
		System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));	//4
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));	//-1
		System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));	//0
	}

}
