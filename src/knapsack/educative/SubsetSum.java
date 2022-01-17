package knapsack.educative;

/**
 * In the top-down approach we tried solving big problem first and subsequently solved sub problems
 * In the bottom-up approach as we already know we need solutions to sub problems we can first solve sub problems
 * 
 * From Aditya almost same as educative. But easy to remember
 * 1. create t[n+1][sum+1]
 * 2. Fill first row = false and first column = true
 * 3. for i = 1 -> n
 *     for j = 1 -> sum
 *     if(num[i-1] < j)	//2 choices 
 *       t[i][j] = t[i-1][j-num[i-1]]
 *       				||
				   t[i-1][j])
 *     else	//cannot participate
 *     	 t[i][j] = t[i-1][j];
 *     
 * Time Complexity: O(N * S)
 * Space Complexity: O(N * S)
 */
public class SubsetSum {
	
	public static boolean canPartition(int[] num, int sum) {
		int n = num.length;
		boolean t[][] = new boolean[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = false;	//first row = false
				if(j == 0)
					t[i][j] = true;		//first column = true
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(num[i-1] <= j) {
					t[i][j] = t[i-1][j-num[i-1]] 	//including
								||
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if num[i-1] > j copy from previous
				}
			}
		}
		
		return t[n][sum];
	}
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 7 };
		System.out.println(canPartition(num, 6));	//true {1, 2, 3}
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(canPartition(num, 10));	//true {1, 2, 7}
		num = new int[] { 1, 3, 4, 8 };
		System.out.println(canPartition(num, 6));	//false 
	}
}
