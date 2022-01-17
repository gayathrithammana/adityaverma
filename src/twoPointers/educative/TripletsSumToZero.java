package twoPointers.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1st loop 0 -> n-3	- index
 * 2nd loop 1 -> n-2	- i
 * 3rd loop 2 -> n-1	- j
 * 
 * Time Complexity O(N * longN + N^2) -> O(N^2)
 * Space Complexity O(N) - for sorting if we are not using an in-place sorting algorithm
 */

public class TripletsSumToZero {
	
	private static List<List<Integer>> getTriplets(int[] arr) {
		Arrays.sort(arr);
		
		List<List<Integer>> triplets = new ArrayList<>();
		
		for(int index=0;index<arr.length-2;index++) {
			if(index > 0 && arr[index] == arr[index-1])	//we have calculated pair already in prev step
				continue;
			
			findPairSum(arr, -arr[index], index+1, triplets);
				
		}
		return triplets;
	}
	
	private static List<List<Integer>> findPairSum(int[] arr, int targetSum, int i, List<List<Integer>> triplets) {
		
		int j = arr.length - 1;
		
		while(i < j) {
			int currentSum = arr[i] + arr[j];
			if (currentSum == targetSum) {
				triplets.add(Arrays.asList(-targetSum, arr[i], arr[j]));
				i++;	
				j--;	//continue loop as there can another pair
				
				//if element is same as previous skip the index
				
				while(i < j && arr[i] == arr[i-1])
					i++;
				while(i < j && arr[j] == arr[j+1])
					j--;
			}
			else if (currentSum > targetSum)
				j--;
			if (currentSum < targetSum)
				i++;
		}
		
		return triplets;
	}

	public static void main(String[] args) {
		List<List<Integer>> triplets = getTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2});
		for(List<Integer> oneList : triplets) {
			System.out.println(oneList);
		}
		
		triplets = getTriplets(new int[] {-5, 2, -1, -2, 3});
		for(List<Integer> oneList : triplets) {
			System.out.println(oneList);
		}
	}

}
