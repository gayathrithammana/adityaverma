package longestCommonSubseq;

/**
 * 
 *Leetcode 1312. Minimum Insertion Steps to Make a String Palindrome
* 1. Minimum no.of insertions to make it Longest Palindromic subsequence
* 		a -> a
* 		b -> reverse(a)
*		Min no. of insertions = slength - LPS(s)
* 2. Minimum no.of deletions to make it Longest Palindromic subsequence
* 		a -> a
* 		b -> reverse(a)
* 		Min no. of deletions = slength - LPS(s)
* 

*/
public class MinNoOfInsertionsLPS {
	public static int minNoOfDeletions(String s) {
		return s.length() - LongestPalindromicSubSeq.longestPalindromicSubSequence(s);
	}
	
	public static int minNoOfInsertions(String s) {
		return minNoOfDeletions(s);
	}
	
	public static void main(String[] args) {
		System.out.println(minNoOfDeletions("agbcba")); //g = 1
		System.out.println(minNoOfInsertions("aebcbda")); //adebcbeda = 2
	}
}
