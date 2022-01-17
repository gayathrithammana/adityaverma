package knapsack.educative;

/**
 * Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
 * 
 * Followed Aditya
 * 
 * 1. Find total sum of given array
 * 2. Find t[][] from subset sum problem subset(nums, totalSum)
 * 3. Last row contains candidates that can sum upto totalSum
 *    - we have to minimize S2 - S1 , assume S2 is sum of second half - larger numbers
 *    									     S1 is sum of first half - smaller numbers
 *    - and we know S1 + S2 = S
 *      
 *      Hence S2 - S1 = S - S1 - S1
 *      		      = S - 2S1
 * 4. Now we can find min of S - 2S1 using first half of last row
 */

public class MinimumSubsetSumDifference {
	public static int minDiff(int[] num) {
		int sum = 0;
		for(int i:num)
			sum += i;
		
		//subset sum
		int n = num.length;
		boolean t[][] = new boolean[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = false;	//first row = false
				if(j == 0)
					t[i][j] = true;		//first column = true
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(num[i-1] <= j) {
					t[i][j] = t[i-1][j-num[i-1]] 	//including
								||
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if num[i-1] > j copy from previous
				}
			}
		}
		
		//add half of last row to list and find min diff
		int minDiff = Integer.MAX_VALUE;
		for(int j=0; j <= sum/2; j++) {
			if(t[n][j])
				minDiff = Math.min(minDiff, sum - (2 * j));
		}
		
		return minDiff;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 9 };			//3
		System.out.println(minDiff(num));
		num = new int[] { 1, 2, 7, 1, 5 };	//0
		System.out.println(minDiff(num));
		num = new int[] { 1, 3, 100, 4 };	//92
		System.out.println(minDiff(num));
	}
}
