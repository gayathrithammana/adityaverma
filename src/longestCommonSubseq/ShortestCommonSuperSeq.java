package longestCommonSubseq;

/**
 * length = l1 + l2 - LCS(s1, s2)
 */
public class ShortestCommonSuperSeq {
	private static int shortestCommonSuperSeq(String s1, String s2) {
		return s1.length() + s2.length() - TopDownDPLengthOfLCS.longestCommonSubSequence(s1, s2, s1.length(), s2.length());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestCommonSuperSeq("abcdeh", "abdehr")); //abcdehr = 7

	}
}
