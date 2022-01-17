package twoPointers.educative;

/**Find one spoiler from beginning of the array
 * second spoiler from end of the array
 * 
 * find min, max in that window and compare elements left and right to them are in correct position
 * 
 * otherwise increase window size
 * 
 * Time Complexity O(N)
 * Space Complexity O(1)
 */

public class MinimunWindowSort {
	
	private static int lengthOgArrayNeedToBeSorted(int[] arr) {
		int len = arr.length;
		int low = 0;
		int high = len - 1;
		
		//find first index that is out of sorting
		while(low < len - 1 && arr[low] <= arr[low+1])
			low++;
		
		if(low == len - 1)	//array is sorted
			return 0;
		
		while(high > 0 && arr[high] >= arr[high-1])
			high--;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=low; i<=high; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		while(low > 0 && arr[low-1] > min)
			low--;
		
		while(high < len-1 && arr[high+1] < max)
			high++;
		
		return high- low + 1;
	}

	public static void main(String[] args) {
		System.out.println(lengthOgArrayNeedToBeSorted(new int[] {1, 2, 5, 3, 7, 10, 9, 12}));	//5,3,7,10,9 need to be sorted
		System.out.println(lengthOgArrayNeedToBeSorted(new int[] {1, 3, 2, 0, -1, 7, 10}));	//1, 3, 2, 0, -1 need to be sorted
	}

}
