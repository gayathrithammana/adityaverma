package twoPointers.educative;

import java.util.Arrays;

/**
 * Problem:
 * 
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is 
 * as close to the target number as possible, return the sum of the triplet. 
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * 1st loop 0 -> n-3	- index
 * 2nd loop 1 -> n-2	- i
 * 3rd loop 2 -> n-1	- j
 * 
 * Time Complexity O(N * longN + N^2) -> O(N^2)
 * Space Complexity O(N) - for sorting if we are not using an in-place sorting algorithm
 */
public class TripletsSumCloseToTarget {

	private static Integer getTripletsCloseToTarget(int[] arr, int targetSum) {
		Arrays.sort(arr);
		
		int minDiff = Integer.MAX_VALUE;
		
		for(int index=0;index<arr.length-2;index++) {
			int i = index + 1;
			int j = arr.length - 1;
			
			while(i < j) {
				int currentDiff = targetSum - (arr[index] + arr[i] + arr[j]);
				
				if(currentDiff == 0)
					return arr[index] + arr[i] + arr[j];//matching triplet found where current sum is exactly equal to target sum
				
				//case 1. save min diff
				//case 2. if more than one such triplet, return the sum of the triplet with the smallest sum.
				// smallest sum means biggest diff
				if(Math.abs(currentDiff) < Math.abs(minDiff)
						|| (Math.abs(currentDiff) == Math.abs(minDiff) && currentDiff > minDiff))
					minDiff = currentDiff;
				
				if(currentDiff > 0)	//if diff is more means we need a triplet with bigger sum 
					i++;			//to make the diff small
				else				//if diff is less means we need a triplet with smallest sum 
					j--;			//to make the diff small
			}
				
		}
		return targetSum - minDiff;
	}
	

	public static void main(String[] args) {
		System.out.println(getTripletsCloseToTarget(new int[] {-2, 0, 1, 2}, 2));	//{-2, 1, 2} = 1
		System.out.println(getTripletsCloseToTarget(new int[] { -3, -1, 1, 2 }, 1)); //{-1, 1, 2} = 0 
	    System.out.println(getTripletsCloseToTarget(new int[] { 1, 0, 1, 1 }, 100)); //{1, 1, 1} = 3
	}

}
