package kWayMerge.educative;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Similar Leetcode Problem 373. Find K Pairs with Smallest Sums
 * 
 * Given two sorted arrays in descending order, 
 * find ‘K’ pairs with the largest sum where each pair consists of numbers from both the arrays.
 * 
 * 1. for each numbers in nums1 and for each numbers in nums2
 * 2. if heap size < k add pair to minHeap
 * 3. else
 *    - if top elements are greater than current pair return pair
 *    - else pop and add current pair
 *    
 *
 * Time Complexity: O(N * MlogK)
 * Space Complexity: O(K)
 */
public class KPairsWithLargestSum {
	public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a1, a2) -> (a1[0] + a1[1]) - (a2[0] + a2[1]));

		for (int i = 0; i < nums1.length && i < k; i++) {
			for (int j = 0; j < nums2.length && j < k; j++) {
				if (minHeap.size() < k)
					minHeap.add(new int[] { nums1[i], nums2[j] });
				else {
					// if the sum of the two numbers from the two arrays is smaller than the smallest (top) element of
					// the heap, we can 'break' here.
					//Since the arrays are sorted in the descending order, we'll not be
					// able to find a pair with a higher sum moving forward.
					if ((minHeap.peek()[0] + minHeap.peek()[1]) > (nums1[i] + nums2[j]))
						break;
					else {
						minHeap.poll();
						minHeap.add(new int[] { nums1[i], nums2[j] });
					}
				}
			}
		}

		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		int[] l1 = new int[] { 9, 8, 2 };
		int[] l2 = new int[] { 6, 3, 1 };
		List<int[]> result = findKLargestPairs(l1, l2, 3);	//[9, 3] [9, 6] [8, 6] 
		System.out.print("Pairs with largest sum are: ");
		for (int[] pair : result)
			System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
	}
}
