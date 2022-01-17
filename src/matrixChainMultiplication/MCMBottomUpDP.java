package matrixChainMultiplication;

/**
 * given array of elements which are dimensions of arrays
 * we should find minimum cost such that matrix multiplication is minimum
 * 
 * A -> 10*30
 * B -> 30*5
 * C -> 5*60
 * 
 * 1.(AB)C 
 *  AB = 10*30 30*5 => resultant matrix dimension will be 10*5
 *  cost = 10*30*5
 *  
 *  Now multiply with C
 *  => 10*5 5*60
 *  cost =  10*30*5 + 10*5*60 = 4500
 *  
 * 2.A(BC)
 * BC = 30*5  5*60 => resultant matrix dimension will be 30*60
 * cost = 30*5*60
 * 
 * Now multiply with A
 * => 10*30 30*60 
 *  cost = 30*5*60 + 10*30*60 = 2700 
 *  
 *  Min cost is 2700
 *
 */

public class MCMBottomUpDP {

	private static int mcm(int[] arr, int i, int j, int[][] t) {
		if (i >= j)
			return 0;

		if (t[i][j] != -1)
			return t[i][j];

		int mn = Integer.MAX_VALUE;

		for (int k = i; k <= j-1; k++) {
			int totalCost = mcm(arr, i, k, t) + 
					   		mcm(arr, k + 1, j, t) + 
					   		arr[i - 1] * arr[k] * arr[j];

			if (totalCost < mn)
				mn = totalCost;
		}

		t[i][j] = mn;
		return mn;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 40, 20, 30, 10, 30 };
		int len = arr.length;
		int t[][] = new int[len + 1][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(mcm(arr, 1, len - 1, t)); // arr, i, len-1
		//A1 - 40*20
		//A2 - 20*30
		//A3 - 30*10
		//A4 - 10*30
	}

}
