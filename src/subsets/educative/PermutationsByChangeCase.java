package subsets.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation 
 * 
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * solve using Aditya Verma videos
 * 1. take first char from input 
 * 2. if char is alphabet convert op1 to op + lowercase(firstchar)
 *    - 					   and  op2 to op + uppercase(firstchar)
 *    - remove firstchar from input
 *    - solve recursively
 * 3. if char is not alphabet append first char to op
 *    - remove firstchar from input
 *    - solve recursively
 * 4. if input length == 0 add output to result 
 * 
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */

public class PermutationsByChangeCase {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		findPermutations(str, "", permutations);
		return permutations;
	}

	private static void findPermutations(String ip, String op, List<String> permutations) {
		if(ip.length() == 0) {
			permutations.add(op);
			return;
		}
		
		char firstChar = ip.charAt(0);
		
		if(Character.isAlphabetic(firstChar)) {
			String op1 = op;
			String op2 = op;
			
			op1 += Character.toLowerCase(firstChar);
			op2 += Character.toUpperCase(firstChar);
			
			ip = ip.substring(1);
			
			findPermutations(ip, op1, permutations);
			findPermutations(ip, op2, permutations);
		} else {
			op += firstChar;
			ip = ip.substring(1);
			findPermutations(ip, op, permutations);
		}
		
		
	}

	public static void main(String[] args) {
		List<String> result = findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		result = findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}
}
