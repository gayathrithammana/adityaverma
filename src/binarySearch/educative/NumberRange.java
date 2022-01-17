package binarySearch.educative;

/** Leetcode 34. Find First and Last Position of Element in Sorted Array
 * find the range of a given number ‘key’. 
 * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 *  apply binary search
 * 1. continue binary search for finding start of range in first half
 * 2. if key found continue binary search for finding end of range in second half
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class NumberRange {
	public static int[] findRange(int[] arr, int key) {
		int[] result = new int[] { -1, -1 };
		result[0] = search(arr, key, true);	//search in first half for the range start
		if(result[0] != -1)
			result[1] = search(arr, key, false);	//search in second half for the range end
		
		return result;
	}

	private static int search(int[] arr, int key, boolean isFirstIndex) {
		
		int keyIndex = -1;
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(key < arr[mid])
				end = mid - 1;	//search in first half
			else if(key > arr[mid])
				start = mid + 1;	//search in second half
			else {
				keyIndex = mid;
				if(isFirstIndex)
					end = mid - 1;	//search in first half
				else
					start = mid + 1; //search in second half
			}
		}
		return keyIndex;
	}

	public static void main(String[] args) {
		int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);	//[1, 3]
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);		//[3, 3]
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);		//[-1, -1]
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
	}
}
