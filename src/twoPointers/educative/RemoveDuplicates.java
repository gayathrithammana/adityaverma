package twoPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class RemoveDuplicates {
	// swap and count - from solution
	private static int removeDuplicates(int[] arr) {
		int i = 1;

		for (int j = 1; j < arr.length; j++) {
			if (arr[i - 1] != arr[j]) {
				arr[i] = arr[j];
				i++;
			} 
		}
		return i;
	}

	// just counting
	private static int removeDuplicates1(int[] arr) {
		if (arr.length == 0)
			return -1;

		int count = 1;

		int i = 0;
		int j = i + 1;

		for (i = 0; i < arr.length - 2;) {
			if (arr[i] != arr[j]) {
				j++;
				i = j - 1;
				count++;
			} else {
				j++;
			}
		}
		return count;
	}
	
	private static int removeKey(int[] arr, int k) {
		int i=0;
		int j=0;
		for(i = 0; i< arr.length;i++) {
			if(arr[i] != k) {
				arr[j] = arr[i];
				j++;
			}
		}
		return j;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
		System.out.println(removeDuplicates(new int[] { 2, 2, 2, 1 }));
		System.out.println(removeKey(new int[] {3, 2, 3, 6, 3, 10, 9, 3}, 3));
	}

}
