package knapsack.educative;

/**
 * Aditya
 * 
 * Same as subset sum. Replace boolean with int array
 * 
 * Time Complexity: O(N * S)
 * Space Complexity: O(N * S)
 */
public class CountOfSubsets {
	//space optimized - using single array
	// if we see 2d matrix we need only previous record values
	//so we take single array and update
	public static int countSubsets1(int[] num, int sum) {
	    int[] t = new int[sum + 1];
	    t[0] = 1;	//sum 0 is possible with empty set

	    // with only one number, we can form a subset only when the required sum is equal to the number
	    // fill first row - when sum = 0 or sum = num we can fill with 1
	    for(int i=1; i <= sum ; i++)
	      t[i] = (num[0] == i ? 1 : 0);

	    // process all subsets for all sums
	    for(int i = 1; i < num.length; i++) {
	      for(int j = sum; j >= 0; j--) {	//we have to iterate from end -> start cause t[j] depends on t[j-nums[i]]
	          if(num[i] <= j)
	            t[j] += t[j-num[i]];
	      }
	    }

	    return t[sum];
	}
	
	//Aditya verma
	public static int countSubsets(int[] num, int sum) {
		int n = num.length;
		int t[][] = new int[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = 0;	//first row = false
				if(j == 0)
					t[i][j] = 1;		//first column = true
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(num[i-1] <= j) {
					t[i][j] = t[i-1][j-num[i-1]] 	//including
								+
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if arr[i-1] > j copy from previous
				}
			}
		}
		
		return t[n][sum];
	}
	public static void main(String[] args) {
		int[] num = { 1, 1, 2, 3 };
		System.out.println(countSubsets1(num, 4));	//3
		
//		int[] num = { 1, 2, 3, 7 };
//		System.out.println(countSubsets(num, 6));	//1 {1, 2, 3}
//		num = new int[] { 1, 2, 7, 3, 5 };
//		System.out.println(countSubsets(num, 8));	//true {1, 7}, {3, 5}, {1, 2, 5}
//		num = new int[] { 1, 3, 4, 8 };
//		System.out.println(countSubsets(num, 6));	//false 
	}
}
