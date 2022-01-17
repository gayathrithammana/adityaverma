package knapsack.unbounded;

/**
 * the only diff with 0-1 knapsack is
 * in 0-1 candidate can participate only once
 * t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]],
							t[i-1][j])
 * In unbounded knapsack candidate can participate again
 * t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]],
							t[i-1][j])
 *
 */

public class UnboundedTopDown {
	
	public static int unbounded(int[] wt, int[] val, int w, int n) {
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
					t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]],
							t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
//		for(int i=0;i<=n;i++) { 
//			for(int j=0;j<=w;j++) {
//					System.out.print(t[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return t[n][w];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(unbounded(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 50, 3));
	}

}
