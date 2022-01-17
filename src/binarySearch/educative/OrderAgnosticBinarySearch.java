package binarySearch.educative;

/**
 * Find given key index for a given ascending /descending sorted array
 * mid = start + (end - start) / 2
 * 
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class OrderAgnosticBinarySearch {
	
	private static int search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		
		boolean isAscending = arr[start] < arr[end];
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(key == arr[mid])
				return mid;
			
			if(isAscending) {
				if(key < arr[mid])
					end = mid - 1;	//search in first half
				else
					start = mid + 1;	//search in second half
			} else {
				if(key > arr[mid])
					end = mid - 1;	//search in first half
				else
					start = mid + 1;	//search in second half
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
	    System.out.println(search(new int[] { 4, 6, 10 }, 10));	//2
	    System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));	//4
	    System.out.println(search(new int[] { 10, 6, 4 }, 10));	//0
	    System.out.println(search(new int[] { 10, 6, 4 }, 4));	//2
	  }
}
