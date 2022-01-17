package longestCommonSubseq;

/**
 * find minimum no.of insertion and deletion to convert String a to String b
 *  no.of deletion = alength - LCS
 *  no.of insertion = blength - LCS
 */
public class MinNoInsertionDeletionLCS {
	
	public static void noOfInsertionDeletions(String a, String b) {
		int LCS = TopDownDPLengthOfLCS.longestCommonSubSequence(a, b, a.length(), b.length());;
		int noOfDeletions = a.length() - LCS;
		int noOfInsertions = b.length() - LCS;
		
		System.out.println("noOfDeletions.." + noOfDeletions);
		System.out.println("noOfInsertions.." + noOfInsertions);
		
		
	}

	public static void main(String[] args) {
		noOfInsertionDeletions("heap", "pea"); //ea
	}

}
