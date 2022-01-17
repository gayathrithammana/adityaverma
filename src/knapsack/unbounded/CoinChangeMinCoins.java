package knapsack.unbounded;

/** 
 * Leetcode 322. Coin Change
 * Find min no.of coins can sum up to given sum
 * unbounded
 * bit diff from all
 */

public class CoinChangeMinCoins {
	
	public static int findMinCoins(int[] arr, int sum, int n) {
		int t[][] = new int[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(j == 0)								//first column
					t[i][j] = 0;
				if(i == 0)								//first row
					t[i][j] = Integer.MAX_VALUE - 1;
				
				if(i == 1) {							//second row when 1 element 
					if(j % arr[0]  == 0)
						t[i][j] = j / arr[0];
					else
						t[i][j] = Integer.MAX_VALUE - 1;
				}
			}
			
		}
		
		for(int i=2;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = Math.min(t[i][j-arr[i-1]] + 1,	//including
							  t[i-1][j]); 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if arr[i-1] > j copy from previous
				}
			}
		}
		return t[n][sum] > sum ? -1 : t[n][sum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinCoins(new int[] {9, 6, 5, 1}, 11, 4)); //2 - {6, 5}
	}

}
