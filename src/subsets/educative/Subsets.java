package subsets.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 78. Subsets 
 * 1. add empty list to result 
 * 2. for each num in nums add num to each list in result
 * 
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */
public class Subsets {
	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

		subsets.add(new ArrayList<Integer>());
		for (int currentNum : nums) {
			int n = subsets.size();
			for (int i = 0; i < n; i++) {
				List<Integer> list = new ArrayList<Integer>(subsets.get(i));
				list.add(currentNum);
				subsets.add(list);
			}
		}
		return subsets;
	}


	public static void main(String[] args) {
//	    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
//	    System.out.println("Here is the list of subsets: " + result);

		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}
