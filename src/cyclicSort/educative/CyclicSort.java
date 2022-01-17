package cyclicSort.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class CyclicSort {

	public static void sort(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i] != i+1) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1]= nums[i];
				nums[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {3, 1, 5, 4, 2};
		sort(nums);
		for(int i:nums)
			System.out.print(i + " ");
		
		System.out.println();
		nums = new int[] {2, 6, 4, 3, 1, 5};
		sort(nums);
		for(int i:nums)
			System.out.print(i + " ");
		
		System.out.println();
		nums = new int[] {1, 5, 6, 4, 3, 2};
		sort(nums);
		for(int i:nums)
			System.out.print(i + " ");
	}

}
