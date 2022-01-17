package bitwiseXOR.educative;

/**
 * Leetcode 260. Single Number III
 * 
 * https://www.youtube.com/watch?v=3TSC0nlur58
 * 
 * Every number appears twice except two numbers, find those 2 numbers
 * 
 * 1. get XOR of two single numbers xy
 * 2. get right most bit which is 1
 *    while((rightMostBit1 & xy) == 0)
			rightMostBit1 = rightMostBit1 << 1;
 * 3. based on right most bit make 2 groups and find XOR of 2 groups
* Time Complexity : O(N)
* Space Complexity : 1
*/

public class TwoSingleNumbers {
	public static int[] findSingleNumbers(int[] nums) {
		//step1: get XOR of two single numbers xy
		int xy = 0;
		for(int num : nums)
			xy ^= num;
		
		// if a bit in x^y is 1 means x,y have diff bits in that place
		// we can partition nums into 2 groups based on any bit which is 1 in x^y
		//step2: lets find rightmost bit which is 1
		int rightMostBit1 = 1;
		while((rightMostBit1 & xy) == 0)
			rightMostBit1 = rightMostBit1 << 1;
		
		//step3: now based on rightMostBit1 partition nums into 2 groups and find their xor
		//which will single number in that group
		int group1 = 0;
		int group2 = 0;
		for(int num : nums) {
			if((num & rightMostBit1) != 0)
				group1 ^= num;
			else
				group2 ^= num;
		}
				
		return new int[] {group1, group2};
		
		
	}

	public static void main(String args[]) {
		int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };	//6,4
	    int[] result = findSingleNumbers(arr);
	    System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

	    arr = new int[] { 2, 1, 3, 2 };	//1,3
	    result = findSingleNumbers(arr);
	    System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
	}
}
