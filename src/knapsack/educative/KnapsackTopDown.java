package knapsack.educative;

/**
 * If we draw recursive tree there are chances that some of the sub problems are repeating
 * and 
 * If we see recursive approach only capacity and index are changing.
 * Hence, we can have a dp[profits.length][capcity + 1]
 * and save profits in dp[][]
 * 
 * Time Complexity: O(N * C)
 * Space Complexity: O(N * C)
 */
public class KnapsackTopDown {
	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		return solve(profits, weights, capacity, 0, dp);
	}

	private static int solve(int[] profits, int[] weights, int capacity, int index, Integer[][] dp) {
		if(capacity <= 0 || index >= profits.length)
			return 0;
		
		if(dp[index][capacity] != null)
			return dp[index][capacity];
		
		//including profit at current index
		//decrease current weight from capacity and solve recursively
		int profit1 = 0;
		if(weights[index] <= capacity)
			profit1 = profits[index] + solve(profits, weights, capacity - weights[index], index + 1, dp);
		
		//not including current profit and weight
		int profits2 = solve(profits, weights, capacity, index+1, dp);
		
		dp[index][capacity] = Math.max(profit1, profits2);
		
		return Math.max(profit1, profits2);
	}

	public static void main(String[] args) {
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = solveKnapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);	//22
		maxProfit = solveKnapsack(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);	//17
	}
}
