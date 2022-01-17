package subsets.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Leetcode 241. Different Ways to Add Parentheses
 * 
 * Different ways to Evaluate expression
 * 
 * check for given string if result already exists map
 *  1. if str doesnt contain +,-,* , add str to result list
 *  2. else
 *     for each char in str 
 *     - if char is not digit that means operator
 *     - solve left part solve(substring(0, i))
 *     - solve right part solve(substring(i+1))
 *  3. for each left and right part 
 *     find left +/-/* right
 *  4. add to result list(before adding it to result list save it to map)
 *  
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(2^N)
 */

public class EvaluateExpression {
	
	static Map<String, List<Integer>> map = new HashMap<>();

	private static List<Integer> evaluate(String str) {
		if(map.containsKey(str))
			return map.get(str);
		List<Integer> result = new ArrayList<>();
		//if no operators in string we can add given digit directly to list
		if(!str.contains("+") && !str.contains("-") && !str.contains("*"))	
			result.add(Integer.parseInt(str));
		else {
			for(int i=0;i<str.length();i++) {	
				char currentChar = str.charAt(i);
				//for each char if it is operator evaluate its left and right parts
				if(!Character.isDigit(currentChar)) {
					List<Integer> leftParts = evaluate(str.substring(0, i));
					List<Integer> rightParts = evaluate(str.substring(i+1));
					
					for(int left: leftParts) {
						for(int right: rightParts) {
							if(currentChar == '+')
								result.add(left + right);
							else if(currentChar == '-')
								result.add(left - right);
							else if(currentChar == '*')
								result.add(left * right);
						}
					}
				}
			}
		}
		map.put(str, result);
		return result;
	}

	public static void main(String[] args) {
//		List<Integer> result = evaluate("1+2*3");
//		System.out.println("Expression evaluations: " + result);	//[7, 9]

		List<Integer> result = evaluate("2*3-4-5");
		System.out.println("Expression evaluations: " + result);	//[8, -12, 7, -7, -3]
		
		/**
		 * 2*3-4-5
		 * 
		 * suppose at *,  we can solve right parts 3-4-5 below 2 ways
		 * 													3-4-5 solve it recursively
		 * 													3-(4-5) = 4
		 * 													(3-4)-5 = -6
		 * now do left * right 
		 * 			 2 * 3- (4 - 5) = 4
		 * 		     2 * (3-4) - 5 = -6
		 */

	}

}
