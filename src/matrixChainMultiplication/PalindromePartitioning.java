package matrixChainMultiplication;

/**
 * Leetcode 132. Palindrome Partitioning II
 * Find count of Minimize partitions, such that each substring is a palindrome
 * ex: nitik
 * 
 * after 2 partitions
 * n | iti | k
 */

public class PalindromePartitioning {
	
	public static int minParititions(String s, int i, int j, int[][] t) {
		if(i >= j)
			return 0;
		
		if(isPalindrome(s, i, j))
			return 0;
		
		if(t[i][j] != -1)
			return t[i][j];
		
		int mn = Integer.MAX_VALUE;
		
		for(int k = i; k < j; k++) {
			int left = 0;
			int right = 0;
			if(t[i][k] != -1)								//i to k
				left = t[i][k];
			else {
				left = minParititions(s, i, k, t);
				t[i][k] = left;
			}
			
			if(t[k+1][j] != -1)								//k+1 to j
				right = t[k+1][j];
			else {
				right = minParititions(s, k + 1, j, t);
				t[k+1][j] = right;
			}
				
			int temp = 1 + left + right; 
			
			if(temp < mn)
				mn = temp;
		}
		
		t[i][j] = mn;
		return mn;
	}
	
	private static boolean isPalindrome(String s, int start, int end) {
		if(start == end)
			return true;
		if(start > end)
			return false;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "nitik";
		int len = s.length();
		int t[][] = new int[len + 1][len  + 1];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(minParititions(s, 0, len-1, t)); //s, 0, len-1
	}

}
