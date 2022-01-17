package matrixChainMultiplication;

//divide and conquer
// solve(1, k) + solve(k+1, j)

public class MCMRecursive {
	
	public static void main(String[] args) {
		System.out.println(mcm(new int[] {40, 20, 30, 10, 30}, 1, 4)); //arr, i, len-1
	}

	private static int mcm(int[] arr, int i, int j) {
		if(i >= j)
			return 0;
		
		int mn = Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++) {
			int temp = mcm(arr, i, k) +
					   mcm(arr, k+1, j) + 
					   arr[i-1] * arr[k] * arr[j];
			
			if(temp < mn)
				mn = temp;
		}
		
		return mn;
	}

}
