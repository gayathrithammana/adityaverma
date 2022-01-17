package bitwiseXOR.educative;

/**
 * Leetcode 136. Single Number
 * Every number appears twice except for one, find that single number
 * return xor of all numbers
* Time Complexity : O(N)
* Space Complexity : 1
*/
public class SingleNumber {
	public static int findSingleNumber(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++)
			temp ^= arr[i];

		return temp;
	}

	public static void main(String args[]) {
		System.out.println(findSingleNumber(new int[] { 1, 4, 2, 1, 3, 2, 3 })); // 4
	}
}
