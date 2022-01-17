package topKElements.educative;

import java.util.PriorityQueue;

/**
 * Find Kth smallest elements
 * 
 * Use maxHeap which ensures to keep smaller elements in heap(as we will be storing only K elements in heap)
 * 
 * 1. add first K elements to max heap
 * 2. for each element in other n-k elements(k -> nums.length)
 *    - check if peek element in heap is > nums[i]
 *    - if it is pop element from heap and insert nums[i]
 *    
 * Time Complexity: O(N * logK)
 * Space Complexity: O(K)
 */
public class KthSmallestNumber {
	public static int findKthSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
		
		for(int i=0;i<k;i++)
			maxHeap.add(nums[i]);
		
		for(int i=k;i<nums.length;i++) {
			if(nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		
		return maxHeap.poll();
	}

	public static void main(String[] args) {
		int result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
		System.out.println("Kth smallest number is: " + result);	//5

		// since there are two 5s in the input array, our 3rd and 4th smallest numbers
		// should be a '5'
		result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
		System.out.println("Kth smallest number is: " + result);	//5

		result = findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);	//11
	}
}
