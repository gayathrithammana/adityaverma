package longestCommonSubseq;

/**
 * Leetcode 516. Longest Palindromic Subsequence
 * 1. count length of Longest Palindromic subsequence
 * 		a -> a
 * 		b -> reverse(a)
 * 		LPS = LCS(a, b)
 **/


public class LongestPalindromicSubSeq {
	// subseq(not continuous)
	// palindromic
	public static int longestPalindromicSubSequence(String s) {
		return TopDownDPLengthOfLCS.longestCommonSubSequence(s, reverse(s), s.length(), s.length());
	}
	
	private static String reverse(String s) {
		int l = s.length();
		if(l <= 1) 
			return s;
		
		String a = s.substring(0, l/2);
		String b = s.substring(l/2, l);
		
		return reverse(b) + reverse(a);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubSequence("agbcba")); //abcba = 5
		System.out.println(longestPalindromicSubSequence("aacabdkacaa")); //abcba = 5
	}

}
