package longestCommonSubseq;

/**
 * Leetcode 1092. Print Shortest Common Supersequence
 * 
 * Same as printing longest common subsequence
 * 
 * 1. build t[][] same as LCS
 * 2. while printing append to result even if the characters are not equal
 * 
 * 				if(t[i-1][j] > t[i][j-1]) {
					s.insert(0, s1.charAt(i - 1));
					i--;
				}
				else {
					s.insert(0, s2.charAt(j - 1));
					j--;
				}
 * 3. if any characters left in s1 or s2 print them as well
 * 	  while(i > 0) {
			s.insert(0, s1.charAt(i-1));
			i--;
		}
		
		while(j > 0) {
			s.insert(0, s2.charAt(j-1));
			j--;
		}
 *    
 */

public class PrintShortestCommonSuperSequence {
	private static String shortestCommonSuperSeq(String s1, String s2, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {// choice and if true(i.e., equal)
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}

			}
		}
		
		int i = m;
		int j = n;
		StringBuffer s = new StringBuffer();
		while(i > 0 && j > 0) {
			if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
				//insert at beginning
				s.insert(0, s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if(t[i-1][j] > t[i][j-1]) {
					s.insert(0, s1.charAt(i - 1));
					i--;
				}
				else {
					s.insert(0, s2.charAt(j - 1));
					j--;
				}
			}
		}
		
		while(i > 0) {
			s.insert(0, s1.charAt(i-1));
			i--;
		}
		
		while(j > 0) {
			s.insert(0, s2.charAt(j-1));
			j--;
		}
		
		return s.toString();
	
	}

	public static void main(String[] args) {
		System.out.println(shortestCommonSuperSeq("abcdeh", "abdehr", 6, 6)); //abcdehr
		System.out.println(shortestCommonSuperSeq("abac", "cab", 4, 3)); //cabac
	}
}
