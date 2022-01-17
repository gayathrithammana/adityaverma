package cyclicSort.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class FindAllDuplicateNumbers {

	private static List<Integer> findDuplicateNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int len = nums.length;
		while (i < len) {
			if (nums[i] != nums[nums[i] - 1]) {
				// swap
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else
				i++;
		}

		for (int j = 0; j < len; j++) {
			if (nums[j] != j+1)
				list.add(nums[j]);
		}
		return list;
	}

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 4, 4, 5, 5 };
		List<Integer> result = findDuplicateNumbers(nums); // 4, 5
		System.out.println(result);

		nums = new int[] { 5, 4, 7, 2, 3, 5, 3 };
		result = findDuplicateNumbers(nums); // 3, 5
		System.out.println(result);
	}

}
