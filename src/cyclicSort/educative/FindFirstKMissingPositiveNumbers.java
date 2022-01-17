package cyclicSort.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(N + k) - last 2 for loops O(N) + O(k)
 * Space Complexity O(k) - to store extra numbers
 */
public class FindFirstKMissingPositiveNumbers {
	private static List<Integer> findNumbers(int[] nums, int k) {
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
		
		List<Integer> missingNumbers = new ArrayList<>();
		List<Integer> extraNumbers = new ArrayList<>();
		for(int j=0; j < len && (missingNumbers.size() < k); j++) {
			if(nums[j] != j + 1) {
				missingNumbers.add(j + 1);
				extraNumbers.add(nums[j]);	//while adding additional numbers we don't include these numbers
											// as they are part of input array already
			}
		}
		
		//if missing numbers size <k add additional numbers > array length 
		//if they are not part extra numbers
		for(int j=1;missingNumbers.size()<k;j++) {
			int additionalMem = j + nums.length;
			if(!extraNumbers.contains(additionalMem))
				missingNumbers.add(additionalMem);
		}
		
		return missingNumbers;
	}

	public static void main(String[] args) {
		List<Integer> result = findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);	//1, 2, 6
		for(int i:result)
			System.out.print(i+ " ");
		System.out.println();
		
		result = findNumbers(new int[] { 2, 3, 4 }, 3);	//1, 5, 6
		for(int i:result)
			System.out.print(i+ " ");
		System.out.println();
		
		result = findNumbers(new int[] { -2, -3, 4 }, 2);	//1, 2
		for(int i:result)
			System.out.print(i+ " ");
	}
}
