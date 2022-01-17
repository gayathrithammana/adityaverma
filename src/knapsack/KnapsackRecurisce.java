package knapsack;

public class KnapsackRecurisce {
	public static int knapsack(int[] wt, int[] val, int w, int n) {
		if(n == 0 || w == 0)
			return 0;
		if(wt[n-1] <= w) {
			return Math.max(val[n-1] + knapsack(wt, val, w-wt[n-1], n-1), 
					knapsack(wt, val, w, n-1));
		} else {
			return knapsack(wt, val, w, n-1); //cant include
		}
	}
	
	public static void main(String[] args) {
		System.out.println(knapsack(new int[] {1, 3, 4, 5}, new int[] {1, 4, 5, 7}, 6, 4));
	}

}
