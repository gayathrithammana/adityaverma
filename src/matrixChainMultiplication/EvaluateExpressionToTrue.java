package matrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * InterviewBit
 * https://www.interviewbit.com/problems/evaluate-expression-to-true/
 * 
 * Given an expression, with operands and operators (OR , AND , XOR), 
 * in how many ways can you evaluate the expression to true,
 * 
 * we need a flag because when coming to XOR F^T=T or T^F=T 
 * that means not always we have to evaluate for true 
 * we need to evaluate to false in above case
 * 
 * i,j represents T/F
 * k represents operator
 * 
 */
public class EvaluateExpressionToTrue {
	//bottom up with memorization
	private static int evaluate(String s, int i, int j, boolean flag, Map<String, Integer> map) {
		String key = i + " " + j + " " + " " + flag;
		if(map.containsKey(key))
			return map.get(key);
		
		if(i > j) {
			map.put(key, 0);
			return 0;
		}
		if(i == j) { //i,j represents T/F
			if(flag == true) {
				int temp = s.charAt(i) == 'T' ? 1 : 0;
				map.put(key, temp);
				return temp;
			}
			else {
				int temp = s.charAt(j) == 'F' ? 1 : 0;
				map.put(key, temp);
				return temp;
			}
		}
		
		//i to k-1
		//k+1 to j
		int ans = 0;
		for(int k = i+1; k <= j-1; k=k+2) {	//k represents operator which starts from i+1
			int lT = evaluate(s, i, k-1, true, map);
			int lF = evaluate(s, i, k-1, false, map);
			int rT = evaluate(s, k+1, j, true, map);
			int rF = evaluate(s, k+1, j, false, map);
			
			if(s.charAt(k) == '&') {
				if(flag == true)
					ans += lT + rT;
				else 
					ans += lF * rT + 
						   lF * rF + 
						   lT * rF; 
			} else if(s.charAt(k) == '|') {
				if(flag == true) 
					ans += lT * rT +
						   lT * rF +
						   lF * rT;
				else
					ans += lF * rF;
			} else if(s.charAt(k) == '^') {
				if(flag == true)
					ans += lT * rF +
						   lF * rT;
				else
					ans += lT * rT +
					   	   lF * rF;
			}
		}
		
		map.put(key, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "T|F";
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(evaluate(s, 0, s.length() - 1, true, map));	//1
		
		map = new HashMap<String, Integer>();
		s = "T^T^F"; 
		System.out.println(evaluate(s, 0, s.length() - 1, true, map));	//0
	}

}
