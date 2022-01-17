package longestCommonSubseq;

/**
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://www.youtube.com/watch?v=UflHuQj6MVA
 *
 */
public class LongestPalindromicSubstring {
	
	private static String longestPalindrome(String str) {
		int n = str.length();
		int max = 1;
		int dp[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i] = 1;
		}
		
		int start = 0;
		for(int i=0;i<n-1;i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = 1;
				start = i;
				max = 2;
			}
		}
		
		for(int k=3;k<=n;k++) {
			for(int i=0;i<n-k+1;i++) {
				int j = i+k-1;	//end index
				if(dp[i+1][j-1] == 1 && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 1;
					
					if(k > max) {
						start = i;
						max = k;
					}
				}
				
			}
		}
		
		return str.substring(start, start+max);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaabbaa"));
	}

}
