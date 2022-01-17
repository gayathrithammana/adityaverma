package cyclicSort.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */

//1 to n

//think about where to keep value 1 - it should be at 0th index
// which is nothing but nums[nums[i] - 1] = nums[0]
public class FindAllMissingNumbers {
	
	private static List<Integer> findMissingNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int len = nums.length;
		while(i < len) {
			if(nums[i] != nums[nums[i] - 1]) {	
				//swap
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else
				i++;
		}
		
		for(int j=0;j<len;j++) {
			if(nums[j] != j+1)
				list.add(j+1);
		}
		
		return list;
	}

	public static void main(String[] args) {
		
		int[] nums = new int[] { 2, 3, 1, 8, 2, 3, 5, 1};
		List<Integer> result = findMissingNumbers(nums);	//4, 6, 7
		System.out.println(result);
		
		nums = new int[] { 2, 4, 1, 2};
		result = findMissingNumbers(nums);	//3
		System.out.println(result);
		
		nums = new int[] { 2, 3, 2, 1};
		result = findMissingNumbers(nums);	//4
		System.out.println(result);
	}

}
