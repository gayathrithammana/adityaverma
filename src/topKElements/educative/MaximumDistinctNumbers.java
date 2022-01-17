package topKElements.educative;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Similar Leetcode problem: 1481. Least Number of Unique Integers after K Removals 
 * 
 * Given an array of numbers and a number ‘K’, 
 * we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
 * 
 * 1. Create freqMap
 * 2. Iterate freqMap and 
 * 	  - increase distinct count if freq = 1
 *    - else add to minHeap
 * 3. while minHeap is empty
 *    - k -= poll().getValue() - 1
 *    - if(k >= 0)
 *      	distinct++;
 * 4. still if(k >0) we need to remove distinct numbers
 *     distinct -= k 
 * 5. Return distinct
 *    
 *    
 * Time Complexity: O(NlogN + KlogN)
 * Space Complexity: O(N) 
 */
public class MaximumDistinctNumbers {
	public static int findMaximumDistinctElements(int[] nums, int k) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int num : nums)
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		
		int distinct = 0;
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> 
																							e1.getValue() - e2.getValue());
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue() == 1)
				distinct++;
			else
				minHeap.offer(entry);
		}
		
		while(!minHeap.isEmpty()) {
			k -= minHeap.poll().getValue() - 1;
			
			if(k >= 0)
				distinct++;
		}
		
		if(k > 0)
			distinct -= k;
			
		
		return distinct;
	}

	public static void main(String[] args) {
		int result = findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);	//3
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);	//2
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);	//3
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);
	}
}
