package subsets.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode: 46. Permutations 
 * 
 * Time Complexity O(N * N!) 
 * Space Complexity O(N * N!)
 */

public class Permutations {
	public static List<List<Integer>> generatePermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generatePermutationsRecursive(nums, 0, new ArrayList<>(), result);
		return result;
	}

	private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
			List<List<Integer>> result) {
		// permutation is already created. just append to result
		if (nums.length == index)
			result.add(currentPermutation);
		else {
			// create permutation by adding number at current index(nums[index]) at each
			// index(i)
			for (int i = 0; i <= currentPermutation.size(); i++) {
				List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(i, nums[index]);
				generatePermutationsRecursive(nums, index + 1, newPermutation, result);
			}
		}

	}
	
	// iterative approach from educative
	public static List<List<Integer>> generatePermutations1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());
		for (int currentNumber : nums) {
			// we will take all existing permutations and add the current number to create
			// new permutations
			int n = permutations.size();
			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutation = permutations.poll();
				// create a new permutation by adding the current number at every position
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
					newPermutation.add(j, currentNumber);
					if (newPermutation.size() == nums.length)
						result.add(newPermutation);
					else
						permutations.add(newPermutation);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = generatePermutations(new int[] { 1, 3, 5 });
		System.out.print("Here are all the permutations: " + result);
	}
}
