package slidingWindow.educative;

/**
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0 if no such subarray exists.
 * 
 * bit diff from longest subarray 
 */
/***
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class SmallestSubarrayWithSum {
	
	private static int smallestSubarray(int[] arr, int targetSum) {
		int i = 0;
		int j = 0;
		int minSize = 0;
		int sum = 0;
		
		while(j < arr.length) {
			
			sum += arr[j];
			
			if(sum < targetSum) {
				j++;
			} else {
				//shrink the array from left
				while(sum >= targetSum ) {
					//cal minimum sub array size
					if(minSize == 0)
						minSize = j-i+1;
					else 
						minSize = Math.min(minSize, j-i+1);
					
					sum -= arr[i];
					i++;
				}
				
				j++;
			}
			
			
			
			
		}
		
		return minSize;
	}

	public static void main(String[] args) {
		System.out.println(smallestSubarray(new int[] {2, 1, 5, 2, 3, 2}, 7)); //5+2 >= 7, len = 2
		System.out.println(smallestSubarray(new int[] {2, 1, 5, 2, 8}, 7)); //8 >= 7, len = 1
		System.out.println(smallestSubarray(new int[] {3, 4, 1, 1, 6}, 8)); //3+4+1 >= 8, len = 3
	}

}
