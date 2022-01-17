package slidingWindow;

/**
 * Given an array of integers and a number k, find maximum sum of a subarray of size k.
 * @author Gaya 3
 */

public class MaxSumSubarrayOfSizeK {

	public static int maxSum(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while (j < arr.length) {
			
			sum = sum + arr[j];
			
			if (j - i + 1 < k) 
				j++;
			else if (j - i + 1 == k) {
				max = Math.max(sum, max);
				
				//before sliding revert calculations of i
				sum = sum - arr[i];
				//slide window
				i++;
				j++;
			}
		}
		
		return max;

	}

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20}, 4)); //4 + 2 + 10 + 23 = 39
	}

}
