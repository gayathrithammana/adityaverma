package longestCommonSubseq;

/**
 * Longest common substring
 * Same as longest common subsequence
 * when charAt(i-1) != charAt(j-1)
 * 	t[i][j] = 0
 */
public class LongestCommonSubstring {

	public static int longestCommonSubstring(String s1, String s2, int m, int n) {
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
					t[i][j] = 0;
				}

			}
		}
		
		for(int i=0;i<=m;i++) { 
			for(int j=0;j<=n;j++) {
					System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}

		// return max
		int max = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (t[i][j] > max)
					max = t[i][j];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(longestCommonSubstring("abcdeh", "abdehr", 6, 6)); // deh = 3
		System.out.println(longestCommonSubstring("abcbcd", "dcbcba", 6, 6)); // deh = 3

	}
}
