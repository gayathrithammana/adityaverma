package longestCommonSubseq;

/**
 * Leetcode: 1143. count length of Longest Common subsequence
 */
public class TopDownDPLengthOfLCS {
	
	//length of common characters 
	//common subseq(not continuous)
	public static int longestCommonSubSequence(String s1, String s2, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {//choice and if true(i.e., equal)
					t[i][j] = 1 + t[i-1][j-1];
				}
				else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
				
			}
		}
		
		return t[m][n];
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubSequence("abcdeh", "abdehr", 6, 6)); //abdeh = 5
	}

}
