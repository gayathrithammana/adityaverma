package knapsack.educative;

/**
 * 
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack with a capacity ‘C.’ 
 * The goal is to get the maximum profit out of the knapsack items. 
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 * 
 * if we draw recursive tree at every step we have 2 decisions. 
 * To pick an element and not to pick an element. Hence, steps are
 * 
 * 1. cal profit1 by including weight and solve recursive
 *    profit1 = profit[index] + solve(profits, weights, capacity - weight[index], index+1)
 * 2. cal profit2 by not including current weight and solve recursive
 *    profit2 = solve(profits, weights, capacity, index+1)
 * 3. return max(profit1, profit2)
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) - for the recursion stack
 *
 */

public class KnapsackRecursive {
	public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		return solve(profits, weights, capacity, 0);
	}

	private static int solve(int[] profits, int[] weights, int capacity, int index) {
		if(capacity <= 0 || index >= profits.length)
			return 0;
		
		//including profit at current index
		//decrease current weight from capacity and solve recursively
		int profit1 = 0;
		if(weights[index] <= capacity)
			profit1 = profits[index] + solve(profits, weights, capacity - weights[index], index + 1);
		
		//not including current profit and weight
		int profits2 = solve(profits, weights, capacity, index+1);
		
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
