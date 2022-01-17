package binarySearch.educative;

/**
 * 1.apply binary search while(start < end)
 * 2. arr[mid] > arr[mid + 1] - search in first half 
 *    end = mid;
 * 3. else search in second half
 *    start = mid + 1;
 * 4. return arr[start] or arr[end]
 *    
 * Time Complexity : O(logN)
 * Space Complexity : 1
 */
public class MaximumInBitonicArray {
	public static int findMax(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + (end-start)/2;
			if(arr[mid] > arr[mid+1])
				end = mid;	//search in first half
			else
				start = mid + 1;	//search in second half
		}
	    return arr[start];
	  }

	  public static void main(String[] args) {
	    System.out.println(findMax(new int[] { 1, 3, 8, 12, 4, 2 }));	//12
	    System.out.println(findMax(new int[] { 3, 8, 3, 1 }));	//8
	    System.out.println(findMax(new int[] { 1, 3, 8, 12 }));	//12
	    System.out.println(findMax(new int[] { 10, 9, 8 }));	//10
	  }
}
