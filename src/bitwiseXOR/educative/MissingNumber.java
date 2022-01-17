package bitwiseXOR.educative;

/**
 * Given an array of n-1 integers in the range from 1 to n,
 * find the one number that is missing from the array.
 * 
 * 1. Find actual sum form 1 to n
 * 	  (i=2 -> arr.length + 1) -> actualSum ^= i
 * 2. Find sum of given array
 *    (i=1 -> arr.length - 1) -> sum ^= arr[i]
 * 3. return actualSum ^ sum
 * 
 * Time Complexity : O(N)
 * Space Complexity : 1
 */
public class MissingNumber {
	
	public static int findMissingNumber(int[] arr) {
		int actualSum = 1;
		for(int i=2; i <= arr.length+1; i++)	//in given array one element is missing we need to include that as well
			actualSum ^= i;
		
		int sum = arr[0];
		for(int i=1; i < arr.length; i++)
			sum ^= arr[i];
		
		return actualSum ^ sum;
	}
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 2, 6, 4 };
		System.out.print("Missing number is: " + findMissingNumber(arr));	//3
	}
}
