package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22. Generate Parentheses
 * figure out observations from recursive tree for n= 3
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

public class GenerateBalancedParentheses {
	
	private static void solve(int open, int close, String op, List<String> list) {
		if(open == 0 && close == 0) {
			list.add(op);
			return;
		}
		
		if(open != 0) {
			String op1 = op + "(";
			solve(open - 1, close, op1, list);
		}
		
		if(close > open) {
			String op2 = op + ")";
			solve(open, close- 1, op2, list);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> list = new ArrayList<String>();
		
		int open = n;
		int close = n;
		
		String op = "";
		solve(open, close, op, list);
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}
