package knapsack.unbounded;

/**
 * find maximum profit obtainable by cutting up the rod and selling the pieces
 * same as unbounded knapsack
 * rod lengths = wt, prices = values
 */

public class RodCutting {
	
	public static int maxProfit(int[] len, int price[], int n, int size) {
		int t[][] = new int[n+1][size+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=size;j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=size;j++) {
				if(len[i-1] <= j) {
					t[i][j] = Math.max(price[i-1] + t[i][j-len[i-1]],
							t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, new int[] {1, 5, 8, 9, 10, 17, 17, 20},
				8, 8));
	}

}
