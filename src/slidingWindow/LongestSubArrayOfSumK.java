package slidingWindow;

//below solution works for +ve numbers
//for -ve numbers follow this
//https://www.geeksforgeeks.org/longest-sub-array-sum-k/


public class LongestSubArrayOfSumK {
	public static int longest(int[] arr, int targetSum) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxSize = 0;
		
		while (j < arr.length) {
			
			sum = sum + arr[j];
			
			if (sum < targetSum) 
				j++;
			else if (sum   == targetSum) {
				maxSize = Math.max(maxSize, j - i + 1);
				j++;
			}
			
			if(sum > targetSum) {
				while(sum > targetSum) {
					sum = sum - arr[i];	//remove elements from left from sum
					i++;
				}
				
				j++;
			}
			
		}
		
		return maxSize;

	}

	public static void main(String[] args) {
		System.out.println(longest(new int[] {4, 1, 1, 1, 2, 3, 5}, 5)); //1+1+1+2=5 ,len = 4
		System.out.println(longest(new int[] {2, 1, 5, 2, 3, 2}, 7)); //2+3+2=7, len = 3
	}
}
