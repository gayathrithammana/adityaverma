package bitwiseXOR.educative;

/**
 * Leetcode 832. Flipping an Image
* Time Complexity : O(n)
* Space Complexity : 1
*/

public class FlipAndInvertMatrix {
	public static int[][] flipAndInvertImage(int[][] arr) {
		int n = arr[0].length;
		for(int[] row : arr) {
			for(int i=0; i < (n+1)/2; i++) {
				int temp = row[i] ^ 1;
				row[i] = row[n - 1 - i] ^ 1;
				row[n - 1 - i] = temp;
			}
		}
		
		return arr;
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		/**
		   0 1 0 
		   0 0 0 
		   0 0 1 
		 */
		int[][] arr = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		print(flipAndInvertImage(arr));
		System.out.println();
		
		/**
		   1 1 0 0 
		   0 1 1 0 
		   0 0 0 1 
		   1 0 1 0 
		 */
		int[][] arr2 = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
		print(flipAndInvertImage(arr2));
	}
}
