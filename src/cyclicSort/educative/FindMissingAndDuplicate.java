package cyclicSort.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class FindMissingAndDuplicate {
	private static int[] findMissingAndDuplicateNumber(int[] nums) {
		
		int result[] = new int[2];
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
			if (nums[j] != j+1) {
				result[0] = nums[j];
				result[1] = j+1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = findMissingAndDuplicateNumber(new int[] { 3, 1, 2, 5, 2 }); 
		System.out.println(nums[0] + ", " + nums[1]);
	    nums = findMissingAndDuplicateNumber(new int[] { 3, 1, 2, 3, 6, 4 });
	    System.out.println(nums[0] + ", " + nums[1]);
	}
}
