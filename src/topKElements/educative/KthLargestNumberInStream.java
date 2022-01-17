package topKElements.educative;

import java.util.PriorityQueue;

/**
 * Leetcode 703. Kth Largest Element in a Stream
 * 
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 * 
 * Use minHeap which ensures to keep largest elements in heap(as we will be storing only K elements in heap)
 * 
 * 1. in constructor for each num call add()
 * 2. in add() check 
 *    - if heap size is < limit . if so, add it simply
 *    - else if given num > peek(). if so pop element and add given num
 *    
 *    
 * Time Complexity: - ad will take O(logN)
 * Space Complexity: O(K) 
 */

public class KthLargestNumberInStream {
	static PriorityQueue<Integer> minHeap;
	static int limit;
	public KthLargestNumberInStream(int[] nums, int k) {
		minHeap = new PriorityQueue<Integer>(k);
		limit = k;
		
		for(int num : nums)
			add(num);
	}

	public int add(int num) {
		if(minHeap.size() < limit)
			minHeap.add(num);
		else if(num > minHeap.peek()) {
			minHeap.poll();
			minHeap.offer(num);
		}
		
		return minHeap.peek();
		
	}

	public static void main(String[] args) {
		int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
		KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
		System.out.println("4th largest number is: " + kthLargestNumber.add(6));
		System.out.println("4th largest number is: " + kthLargestNumber.add(13));
		System.out.println("4th largest number is: " + kthLargestNumber.add(4));
	}
}
