package recursion;

/**
 * grammar:
 * 1 -> 0 1
 * 1 -> 1 0
 * 
 * if 
 * n=1		0
 * n=2		0 1
 * n=3		0 1 1 0
 * n=4		0 1 1 0 1 0 0 1
 * k(pos)   1 2 3 4 5 6 7 8
 */

public class KthSymbolOfGrammar {
	
	private static int solve(int n, int k) {
		if(n == 1 && k == 1)
			return 0;
		
		int mid = (int) ((Math.pow(2, n-1)) / 2);
		
		if(k <= mid)
			return solve(n - 1, k);
		else {
			int result = solve(n - 1, k - mid);
			return (result == 0) ? 1 : 0;
		}
			
	}

	public static void main(String[] args) {
		System.out.println(solve(4, 5));
	}

}
