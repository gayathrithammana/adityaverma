package cyclicSort.educative;


/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class FindSmallestMissingPositive {

	private static int findNumber(int[] nums) {
		int i = 0;
		int len = nums.length;
		
		while(i < len) {
			if(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
				//swap
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else
				i++;
		}
		
		for(int j=0;j<len;j++) {
			if(nums[j] != j+1)
				return j+1;
		}
		
		return nums.length + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(findNumber(new int[] { -3, 1, 5, 4, 2 }));	//3
		System.out.println(findNumber(new int[] { 3, -2, 0, 1, 2 }));	//4
		System.out.println(findNumber(new int[] { 3, 2, 5, 1 }));		//4
		
	}

}
