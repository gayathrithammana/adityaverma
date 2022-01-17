package cyclicSort.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */

//1 to n
public class FindDuplicateNumber {
	private static int findDuplicateNumber(int[] nums) {

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
				return nums[j];
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicateNumber(new int[] { 1, 4, 4, 3, 2 })); // 4
		System.out.println(findDuplicateNumber(new int[] { 2, 1, 3, 3, 5, 4})); // 3
		System.out.println(findDuplicateNumber(new int[] { 2, 4, 1, 4, 4})); // 4
	}
}
