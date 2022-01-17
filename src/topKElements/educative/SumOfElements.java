package topKElements.educative;

import java.util.PriorityQueue;

/**
 * Leetcode problem: 
 * 
 * Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array
 * 
 * Use MaxHeap
 * 1. while adding all elements to maxHeap try to keep only k2 small numbers in heap
 * 2. for first k2-k1-1 elements cal sum 
 *    
 *    
 * Time Complexity: O(NlogK2) - to put first k2 numbers in maxHeap
 * Space Complexity: O(K2) 
 */
public class SumOfElements {
	public static int findSumOfElements(int[] nums, int k1, int k2) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
		
		// keep smallest k2 numbers in the max heap
		for(int i=0; i< nums.length; i++) {
			if(i < k2-1)
				maxHeap.add(nums[i]);
			else if(nums[i] < maxHeap.peek()) {	// as we are interested only in the smallest k2 numbers
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
				
		}
		
		int sum = 0;
		for(int i=0; i < k2 - k1 - 1;i++)
			sum += maxHeap.poll();
		
		return sum;
	}

	public static void main(String[] args) {
		int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);	//23
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

		result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);	//12
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
	}
}
