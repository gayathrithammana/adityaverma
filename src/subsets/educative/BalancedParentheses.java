package subsets.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22. Generate Parentheses
 * 
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses
 * solve using Aditya Verma videos
 * 1. start with open
 * 2. if open !=0 use open
 * 3. if close > open use close
 * 4. repeat above steps
 * 
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */
public class BalancedParentheses {
	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		generate(num - 1, num, "(", result);
		return result;
	}

	private static void generate(int open, int close, String op, List<String> result) {
		if(open == 0 && close == 0) {
			result.add(op);
			return;
		}
		
		if(open != 0) {
			String op1 = op + "(";
			generate(open - 1, close, op1, result);
		} 
		
		if(close > open) {
			String op2 = op + ")";
			generate(open, close - 1, op2, result);
		}
	}

	public static void main(String[] args) {
		List<String> result = generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}
}
