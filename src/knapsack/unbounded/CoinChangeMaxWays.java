package knapsack.unbounded;

/** 
 * Leetcode 518. Coin Change 2
 * Find total no.of ways coins can sum up to given sum
 * unbounded
 * similar to count of subsets sum
 */
public class CoinChangeMaxWays {
	
	public static int count(int[] arr, int sum, int n) {
		int t[][] = new int[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = 0;	//fill first row with 0s. as no elements present
				if(j == 0)
					t[i][j] = 1;    //fill first column with 1s cause we can select empty set to make sum = 0
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i][j-arr[i-1]] 	//including
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
		System.out.println(count(new int[] {1, 5, 10}, 12, 3));
	}

}
