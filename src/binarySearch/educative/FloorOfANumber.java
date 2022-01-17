package binarySearch.educative;

/** 
 * Find floor of a number , index of number >= key, for a given sorted array
 * or
 * Find biggest element in the given array smaller than or equal to the key
 * 1. apply binary search
 * 2. return end
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class FloorOfANumber {
	
	public static int searchFloorOfANumber(int[] arr, int key) {
		if(key < arr[0])
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
		return end;
	}
	
	public static void main(String[] args) {
		System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));	//1
	    System.out.println(searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));	//3
	    System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));	//2
	    System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));	//-1
	  }
}
