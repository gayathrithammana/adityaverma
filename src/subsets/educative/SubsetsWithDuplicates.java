package subsets.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: 90. Subsets II. 
 * 
 * 1.sort the nums
 * 2.add empty list to result 
 * 3.for each num in nums add num to each list in result
 	- if duplicate found dont add num to everything . Just add to the recently added list 
 * 
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */
public class SubsetsWithDuplicates {
	public static List<List<Integer>> findSubsets(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());
		
		int startIndex = 0;
		int endIndex = 0;
		
		for (int i=0;i<nums.length;i++) {
			startIndex = 0;
			
			// if duplicate found ,  create new subsets only from the subsets added in the previous step
			//i.e, start index should point to previous end of result set  
			if(i > 0 && nums[i] == nums[i-1])
				startIndex = endIndex + 1;
			
			endIndex = subsets.size() - 1;	//always point to end of result set
			
			for (int j = startIndex; j <= endIndex; j++) {
				List<Integer> list = new ArrayList<Integer>(subsets.get(j));
				list.add(nums[i]);
				subsets.add(list);
			}
		}
		return subsets;
	}


	public static void main(String[] args) {
//	    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
//	    System.out.println("Here is the list of subsets: " + result);

		List<List<Integer>> result = findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}
