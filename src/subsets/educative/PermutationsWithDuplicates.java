package subsets.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=A3ge2mdQi4g
public class PermutationsWithDuplicates {
	public static List<List<Integer>> generatePermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		generatePermutationsRecursive(nums, new ArrayList<>(), used, result);
		return result;
	}

	private static void generatePermutationsRecursive(int[] nums, List<Integer> currentPermutation, boolean[] used,
													  List<List<Integer>> result) {
		// permutation is already created. just append to result
		int n = nums.length;
		if (n == currentPermutation.size()) {
			result.add(new ArrayList<>(currentPermutation));
			return;
		}
		for (int i = 0; i < n; i++) {
			if(used[i])
				continue;
			
			used[i] = true;
			currentPermutation.add(nums[i]);
			generatePermutationsRecursive(nums, currentPermutation, used, result);
			used[i] = false;
			currentPermutation.remove(currentPermutation.size() - 1);
			while(i + 1 < n && nums[i] == nums[i+1])
				i++;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = generatePermutations(new int[] { 1, 1, 2 });
		System.out.print("Here are all the permutations: " + result);
	}
}
