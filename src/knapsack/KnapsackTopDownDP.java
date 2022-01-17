package knapsack;

//find max profit - pick the item such that profit is maximized

public class KnapsackTopDownDP {
	
	//w is capacity
	public static int knapsack(int[] wt, int[] val, int w, int n) {	
		int t[][] = new int[n+1][w+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=w;j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=w;j++) {
				if(wt[i-1] <= j) {
					t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]],
							t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=w;j++) {
					System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		
		return t[n][w];
	}
	
	public static void main(String[] args) {
		System.out.println(knapsack(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 50, 3));
		System.out.println(knapsack(new int[] {1, 3, 4, 5}, new int[] {1, 4, 5, 7}, 6, 4));
		System.out.println(knapsack(new int[] {3, 2, 4, 4}, new int[] {4, 3, 2, 3}, 6, 4));
	}

}
