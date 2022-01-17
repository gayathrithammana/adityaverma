package longestCommonSubseq;

//recursive bottom UP approach
//count length of Longest Common subsequence
public class RecursiveBULengthOfLCS {
	
	static final int l1 = 6;
	static final int l2 = 6;
	
	static int[][] t = new int[l1 + 1][l2 + 1];
	
	public static int LCS(String s1, String s2, int l1, int l2) {
		if(l1 == 0 || l2 == 0)
			return 0;
		
		if(t[l1][l2] != -1)
			return t[l1][l2];
		
		if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {//choice and if true(i.e., equal)
			t[l1][l2] = 1 + LCS(s1, s2, l1 - 1, l2 - 1);
			return t[l1][l2];
		}
		else {
			t[l1][l2] = Math.max(LCS(s1, s2, l1 - 1, l2), 
								 LCS(s1, s2, l1, l2-1));
			return t[l1][l2];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i <= l1; i++) {
			for(int j = 0; j <= l2; j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(LCS("abcdeh", "abdehr", l1, l2)); //abdeh = 5
	}
}
