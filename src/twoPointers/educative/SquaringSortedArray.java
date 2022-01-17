package twoPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(N)
 */
public class SquaringSortedArray {
	
	private static int[] squareSorted(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		
		int left = 0;
		int right = len - 1;
		int resultIndex = len - 1;
		
		while(left <= right) {
			int squareI = arr[left] * arr[left];
			int squareJ = arr[right] * arr[right];
			
			if(squareJ >= squareI) {
				result[resultIndex] = squareJ;
				right--;
			} else {
				result[resultIndex] = squareI;
				left++;
			}
			resultIndex--;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] result = squareSorted(new int[] {-2, -1, 0, 2, 3});
		for(int i: result) {
			System.out.print(i + " ");
		}
	}

}
