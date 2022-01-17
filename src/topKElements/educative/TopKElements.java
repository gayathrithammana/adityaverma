package topKElements.educative;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find K largest elements
 * 
 * Use minHeap which ensures to keep largest elements in heap(as we will be storing only K elements in heap)
 * 
 * 1. add first K elements to min heap
 * 2. for each element in other n-k elements(k -> nums.length)
 *    - check if peek element in heap is < nums[i]
 *    - if it is pop element from heap and insert nums[i]
 *    
 * Time Complexity: O(N * logK)
 * Space Complexity: O(K)
 */

public class TopKElements {
	public static List<Integer> findKLargestNumbers(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
		
		for(int i=0;i<k;i++)
			minHeap.add(nums[i]);
		
		for(int i=k;i<nums.length;i++) {
			if(minHeap.peek() < nums[i]) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		
		System.out.println("peek element " + minHeap.peek());
		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		List<Integer> result = findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println("Here are the top K numbers: " + result);

		result = findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Here are the top K numbers: " + result);
	}
}
