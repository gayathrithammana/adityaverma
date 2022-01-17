package cyclicSort.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
//0 to n
public class FindMissingNumber {

	private static int findMissingNumber(int[] nums) {
		
		int i = 0;
		int len = nums.length;
		while(i < len) {
			if(nums[i] < len && nums[i] != i) {
				//swap
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
			else
				i++;
		}
		
		for(int j=0;j<len;j++) {
			if(nums[j] != j)
				return j;
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] { 4, 0, 3, 1 }));	//2
		System.out.println(findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));	//7
		System.out.println(findMissingNumber(new int[] { 0, 1 }));	//7
	}

}
