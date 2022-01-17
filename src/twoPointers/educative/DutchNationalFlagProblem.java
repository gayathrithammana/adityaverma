package twoPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class DutchNationalFlagProblem {
	
	private static int[] sort012(int[] arr) {
		int i = 0;
		int low = 0;
		int high = arr.length - 1;
		
		while(i <= high) {
			if(arr[i] == 0) {
				swap(arr, i, low);
				low++;
				i++;
			} else if(arr[i] == 1)
				i++;
			else {
				swap(arr, i, high);
				high--;
			}
		}
		
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = sort012(new int[] {1, 0, 2, 1, 0});
		for(int i:arr)
			System.out.print(i + " ");
	}

}
