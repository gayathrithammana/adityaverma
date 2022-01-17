package longestCommonSubseq;

/**
 * Count length of Longest Common subsequence
 * 1. if l1 == 0 || l2 == 0 
 * 		return 0;
 * 2. check from end to start
 *    if s1.charAt(l1-1) == s2.charAt(l2-1)
 *       1 + LCS(s1, s2, l1-1, l2-1)
 *    else
 *       MAX(LCS(s1, s2, l1-1, l2), 
 *           LCS(s1, s2, l1, l2-1))
 *  
 *
 */
public class RecursiveLengthOfLCS {
	
	public static int LCS(String s1, String s2, int l1, int l2) {
		if(l1 == 0 || l2 == 0)
			return 0;
		
		if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) //choice and if true
			return 1 + LCS(s1, s2, l1 - 1, l2 - 1);
		else
			return Math.max(LCS(s1, s2, l1 - 1, l2), 
							LCS(s1, s2, l1, l2-1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS("abcdeh", "abdehr", 6, 6)); //abdeh = 5
	}

}
