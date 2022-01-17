package longestCommonSubseq;

/**
 * InterviewBit https://www.interviewbit.com/problems/repeating-subsequence/
 * count length of Longest Repeating subsequence
 * 
 * ex:       s1 = aabebcdd
 * lets take s2 = aabebcdd
 * ans: abd = 3 because they are repeating aabbdd
 * 
 * that means while doing LCS we just need to check if there is a same character at diff indexes(i != j)
 * if(s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)
 *
 */

public class LongestRepeatingSubSeq {
	
	private static int longestRepeatingSubSequence(String s) {
		
		String s1 = s;
		String s2 = s;
		int m = s.length();
		int n = s.length();
		
		int t[][] = new int[m + 1][n + 1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {//check i != j
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
		System.out.println(longestRepeatingSubSequence("aabebcdd")); //abd = 3
	}
}
