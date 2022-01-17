package twoPointers.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: The main for-loop managing the sliding window takes O(N)
 * but creating subarrays can take up to O(N^2) in the worst case. Therefore overall, our algorithm will take O(N^3)
 * Space complexity:  at most, we need space for O(n^2) output lists. 
 * At worst, each subarray can take O(n) space, so overall, our algorithm’s space complexity will be O(n^3)
 */
public class ProductLessThanTarget {

	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int product = 1;
		int i = 0;
		int j = 0;
		int count = 0;
		while (j < arr.length) {

			product *= arr[j];

			// slide i
			while (product >= target && i < arr.length) {
				product /= arr[i++];
			}
			// since the product of all numbers from left to right is less than the target
			// therefore,
			// all subarrays from left to right will have a product less than the target
			// too; to avoid
			// duplicates, we will start with a subarray containing only arr[right] and then
			// extend it
			List<Integer> tempList = new ArrayList<>();
			for (int temp = j; temp >= i; temp--) {
				tempList.add(0, arr[temp]);
				result.add(new ArrayList<>(tempList));
			}
			if (j >= i)
				count += j - i + 1; // in case only count need to be calculated
			j++;
		}

		System.out.println(count);
		return result;
	}

	public static void main(String[] args) {

		System.out.println(findSubarrays(new int[] { 10, 5, 2, 6 }, 100));
		System.out.println(findSubarrays(new int[] { 1, 2, 3 }, 0));
	}

}
