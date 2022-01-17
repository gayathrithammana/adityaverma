package subsets.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 96. Unique Binary Search Trees
 * 
 * https://www.youtube.com/watch?t=3&v=dN1JqAavM_g&feature=youtu.be
 * 
 * solution 1: use generate BSTs
 * solution 2: DP
 * 	store values in map
 *  left = count(i-1)
 *  right = count(n-i)
 *  for 1 to n
      count(i) += left + right
      
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(2^N)
 */

public class CountUniqueBSTs {
	
	static Map<Integer, Integer> map = new HashMap<>();
	
	private static int countTrees(int n) {
		if(n == 0 || n == 1)
			return 1;
		
		if(map.containsKey(n))
			return map.get(n);
		
		int count = 0;
		for(int i=1;i<=n;i++) {
			int countOfLeftTrees = countTrees(i-1);
			int countOfRightTrees = countTrees(n-i); 
			count +=  countOfLeftTrees* countOfRightTrees;
		}
		
		map.put(n, count);
		return count;
	}
	
	public static void main(String[] args) {
		System.out.print("Total trees: " + countTrees(3)); //5
	}
}
