package knapsack.educative;

/**
 * In the top-down approach we tried solving big problem first and subsequently solved sub problems
 * In the bottom-up approach as we already know we need solutions to sub problems we can first solve sub problems
 * 
 * From Aditya almost same as educative. But easy to remember
 * 1. create t[n+1][capacity+1]
 * 2. Fill first row and first column with 0s
 * 3. for i = 1 -> n
 *     for j = 1 -> capacity
 *     if(weight[i-1] < j)	//2 choices so, find max from 2 choices
 *       t[i][j] = max(profits[i-1] + t[i-1][j-weights[i-1]],
					   t[i-1][j])
 *     else	//cannot participate
 *     	 t[i][j] = t[i-1][j];
 *     
 * Time Complexity: O(N * C)
 * Space Complexity: O(N * C)
 */

public class KnapsackBottomUp {
	
	//aditya
	public static int knapsack(int[] profits, int[] weights, int capacity) {
		int n = profits.length;
		int t[][] = new int[n+1][capacity+1];
		//initialization
		//fill first row and column with 0
		for(int i=0; i <= n; i++) { 
			for(int j=0; j <= capacity; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for(int i=1; i <= n; i++) { 
			for(int j=1; j <= capacity; j++) {
				if(weights[i-1] <= j) {
					t[i][j] = Math.max(profits[i-1] + t[i-1][j-weights[i-1]],
									   t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][capacity];
	}
	
	/** educative
	 * 1. Create a dp[n][capacity+1];
	 * 2. Fill first column with 0s as 
	 *    - because 0 capacity we cannot achieve any profit
	 * 3. Fill the first row with profits[0]
	 *    - First row means we have only one item to put in knapsack i.e., profits[0]
	 *    - for each capacity from(1 to given capacity) check 
	 *      - if weights[0] < c and fill with profits[0] 
	 * 4. For remaining dp[][]
	 *    - if weight[i] is > capacity it cannot participate 
	 *    	- so simply copy solutions from above step
	 *      	profit1 = dp[i-1][c]
	 *    - else it can participate
	 *          profit2 = profits[i] + dp[i - 1][c - weights[i]]
	 *      
	 * 5. dp[i][c] = max(profit1, profit2)
	 * 6. return dp[n][capactity] 
	 */
	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		if(capacity <= 0 || profits.length == 0 || profits.length != weights.length)
			return 0;
		
		int n = profits.length;
		int dp[][] = new int[n][capacity + 1];
		
		//fill first column with 0s
		for(int i=0; i < n ;i++)
			dp[i][0] = 0;
		
		//fill first row with profits[0]
		for(int c=0; c <= capacity ;c++) {
			if(weights[0] <= c)
				dp[0][c] = profits[0];
		}
		
		for(int i=1; i < n ;i++) {
			for(int c=1; c <= capacity; c++) {
				int profit1 = 0;
				if(weights[i] <= c)
					profit1 = profits[i] + dp[i - 1][c - weights[i]];
				
				int profit2 = dp[i - 1][c];
				
				dp[i][c] = Math.max(profit1, profit2);
			}
		}
		
		//in case if we need to print selected weights
		printSelectedWeights(dp, weights, profits, capacity);
		return dp[n-1][capacity];
		
	}
	
	private static void printSelectedWeights(int[][] dp, int[] weights, int[] profits, int capacity) {
		System.out.print("Selected weights are:");
		
		int n = profits.length;
		int totalProfit = dp[n - 1][capacity];
		
		for(int i = n-1; i > 0 ; i--) {
			//if it is not copied from above cell
			if(totalProfit != dp[i-1][capacity]) {		
				System.out.print(" " + weights[i]);
				capacity -= weights[i];
				totalProfit -= profits[i];
			}
		}
		
		if(totalProfit != 0)
			System.out.print(" " + weights[0]);
		
		System.out.println();
	}

	public static void main(String[] args) {
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = knapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);	//22
		maxProfit = knapsack(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);	//17
	}
}
