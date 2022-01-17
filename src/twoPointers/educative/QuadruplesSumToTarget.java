package twoPointers.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity:
 * Sorting the array will take O(N*logN). Overall searchQuadruplets() will take O(N * logN + N^3)
 *  which is asymptotically equivalent to O(N^3)
 *  .
 * Space Complexity: O(N)
 */

public class QuadruplesSumToTarget {
	
	private static List<List<Integer>> getQuadruples(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(int index1=0; index1<arr.length-3; index1++) {
			if(index1 > 0 && arr[index1-1] == arr[index1])
				continue;
			
			for(int index2=index1+1; index2<arr.length-2; index2++) {
				if(index2 > 0 && arr[index2-1] == arr[index2])
					continue;
				
				findPair(arr, index1, index2, result, k);
			}
		}
		return result;
	}

	private static void findPair(int[] arr, int first, int second, List<List<Integer>> result, int k) {
		int i = second + 1;
		int j = arr.length  -1;
		
		while(i < j) {
			int sum = arr[first] + arr[second] + arr[i] + arr[j];
			
			if(sum == k) {
				result.add(Arrays.asList(arr[first],arr[second], arr[i], arr[j]));
				i++;
				j--;
				
				while(i < j && arr[i-1] == arr[i]) 
					i++;
				
				while(i < j && arr[j+1] == arr[j])
					j--;
			} else if(sum < k)
				i++;
			else
				j--;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> quadruples = getQuadruples(new int[] {4, 1, 2, -1, 1, -3}, 1);
		for(List<Integer> oneList : quadruples) {
			System.out.println(oneList);
		}
		
		quadruples = getQuadruples(new int[] {2, 0, -1, 1, -2, 2}, 2);
		for(List<Integer> oneList : quadruples) {
			System.out.println(oneList);
		}
	}

}
