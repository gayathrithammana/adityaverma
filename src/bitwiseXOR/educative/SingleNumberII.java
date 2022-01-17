package bitwiseXOR.educative;

/**
 * Leetcode 137. Single Number II Given an integer array nums where every
 * element appears three times except for one, which appears exactly once. Find
 * the single element and return it.
 */
public class SingleNumberII {
	/**
	 * from leetcode solutions 
	 * Any number that appears a first time will be in set "ones" so it will not be added to "twos". 
	 * Any number appearing a second time would have been removed from set "ones" in the previous step 
	 * 	and will now be added to set "twos". 
	 * Lastly, any number appearing a third time will simply be removed from the set "twos" 
	 * 	and will no longer exist in either set. 
	 * Finally, once we are done iterating over the entire list, 
	 * 	set "twos" would be empty and set "ones" will contain the only number that appears once.
	 **/
	public static int singleNumber(int[] nums) {
		// from solutions
		int ones = 0, twos = 0;
		for (int i = 0; i < nums.length; i++) {
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
	}

	public static void main(String args[]) {
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2 })); // 3
		System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 })); // 99
	}
}
