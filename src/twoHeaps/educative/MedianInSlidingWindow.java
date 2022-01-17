package twoHeaps.educative;

import java.util.PriorityQueue;

/** Leetcode: 480. Sliding Window Median
 * 
 * Median and Sliding window
 * 1. add keyJ to heaps and do rebalance
 * 2. if(window size < k ) j++
 * 3. else if(window size == k )
 * 	 - cal median 
 *   - revert cal for keyI
 *   - i++;
 *   - j++;
 *   
 * Time Complexity - O(N * k) 
 * 					insert - O(logk) due to the insertion in the heap
 * 					removing - O(K)
 * 
 * Space Complexity O(K) - we are storing K numbers
 */

public class MedianInSlidingWindow {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
	
	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		
		int len = nums.length;
		int i = 0;
		int j = 0;
		
		while(j < len) {
			//add
			int keyJ = (int) nums[j];
			if(maxHeap.isEmpty() || keyJ <= maxHeap.peek())
				maxHeap.add(keyJ);
			else
				minHeap.add(keyJ);
			//rebalance heaps
			rebalance();
			
			if(j - i + 1 < k) {
				j++;
				
			} else if(j - i + 1 == k) {
				//find median and pop i
				double median = 0.0;
				if(maxHeap.size() == minHeap.size())
					median = (maxHeap.peek() / 2.0 ) + (minHeap.peek() / 2.0 );	//integer overflow
				else
					median = maxHeap.peek();
				
				result[i] = median;
				
				//slide the window
				int keyI = nums[i];
				if(keyI <= maxHeap.peek())
					maxHeap.remove(keyI);
				else
					minHeap.remove(keyI);
				
				//rebalance heaps
				rebalance();
				i++;
				j++;
			}
				
		}
		return result;
	}
	
	public void rebalance() {
		//check heaps sizes and try to maintain balance
		if(maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if(maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());
	}
	
	public static void main(String[] args) {
		MedianInSlidingWindow slidingWindowMedian = new MedianInSlidingWindow();
		double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);	//1.5 0.5 1.0 4.0 
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
		System.out.println();

		slidingWindowMedian = new MedianInSlidingWindow();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);	//1.0 2.0 3.0
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

}
