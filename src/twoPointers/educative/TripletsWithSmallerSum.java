package twoPointers.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * 
 * Given an array arr of unsorted numbers and a target sum, count all triplets
 * in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
 * different indices. Write a function to return the count of such triplets.
 * 
 * 1st loop 0 -> n-3 - index 2nd loop 1 -> n-2 - i 3rd loop 2 -> n-1 - j
 * 
 * Time Complexity O(N * longN + N^2) -> O(N^2) Space Complexity O(N) - for
 * Space Complexity O(N) - for sorting if we are not using an in-place sorting algorithm
 */
public class TripletsWithSmallerSum {

	private static Integer getTripletsSmallerThanTarget(int[] arr, int targetSum) {
		Arrays.sort(arr);

		int count = 0;

		for (int index = 0; index < arr.length - 2; index++) {
			int i = index + 1;
			int j = arr.length - 1;

			while (i < j) {
				int currentSum = arr[index] + arr[i] + arr[j];

				// if triplet sum at j is < target sum then all i -> j-1 indexes sum will also
				// be < target sum
				// hence count can be j-i
				if (currentSum < targetSum) {
					count += j - i;
					i++;
				} else
					j--;
			}

		}
		return count;
	}

	/*
	 * Time Complexity - O(N^3)
	 * Sorting the array will take O(N * logN).
	 *  The searchPair(), in this case, will take O(N^2) the main while loop will run in O(N) 
	 *  but the nested for loop can also take O(N) - this will happen when the target sum is bigger than every triplet in the array.
	 * 
	 * Space Complexity O(N) - for sorting if we are not using an in-place sorting algorithm
	 */
	private static List<List<Integer>> printTripletsSmallerThanTarget(int[] arr, int targetSum) {
		List<List<Integer>> triplets = new ArrayList<>();

		Arrays.sort(arr);

		for (int index = 0; index < arr.length - 2; index++) {
			int i = index + 1;
			int j = arr.length - 1;

			while (i < j) {
				int currentSum = arr[index] + arr[i] + arr[j];

				// if triplet sum at j is < target sum then all i -> j-1 indexes sum will also
				// be < target sum
				// hence count can be j-i
				if (currentSum < targetSum) {
					for (int temp = j; temp > i; temp--) {
						triplets.add(Arrays.asList(arr[index], arr[i], arr[temp]));
					}
					i++;
				} else
					j--;
			}

		}
		return triplets;
	}

	public static void main(String[] args) {
		System.out.println(getTripletsSmallerThanTarget(new int[] { -1, 0, 2, 3 }, 3)); // [-1, 0, 3], [-1, 0, 2] = 2
		System.out.println(getTripletsSmallerThanTarget(new int[] { -1, 4, 2, 1, 3 }, 5)); // [-1, 1, 4], [-1, 1, 3],
																							// [-1, 1, 2], [-1, 2, 3] =
																							// 4

		List<List<Integer>> triplets = printTripletsSmallerThanTarget(new int[] { -1, 4, 2, 1, 3 }, 5);
		for (List<Integer> oneList : triplets) {
			System.out.println(oneList);
		}
	}

}
