package twoPointers.educative;

import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {
	/**
	 * Time Complexity O(N)
	 * Space Complexity O(1)
	 */
	private static int[] findPair(int[] arr, int k) {

		int result[] = new int[2];
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			int currentSum = arr[i] + arr[j];
			if (currentSum == k) {
				result[0] = i;
				result[1] = j;

				break;
			}

			if (currentSum > k)
				j--;
			else if (currentSum < k)
				i++;

		}
		return result;
	}
	
	//using hashmap
	/**
	 * Time Complexity O(N) 
	 * Space Complexity O(N)
	 */
	private static int[] findPair1(int[] arr, int targetSum) {

		int result[] = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0;i<arr.length;i++){
			if(map.containsKey(targetSum - arr[i])) {
				result[0] = map.get(targetSum - arr[i]);
				result[1] = i;
				return result;
			} else
				map.put(arr[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = findPair1(new int[] { 1, 2, 3, 4, 6 }, 6); // 2+4=6 indexes:1,3
		for (int i : result) {
			System.out.println(i);
		}
	}

}
