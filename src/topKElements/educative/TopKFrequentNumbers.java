package topKElements.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode 347. Top K Frequent Elements
 * 
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 * 
 * Use minHeap to store most freq elements(as we will be storing only K elements in heap)
 * 
 * 1. create a freq map
 * 2. for each map entry add entry to minHeap 
 *    - if size > k pop entry from minHeap
 * 3. pop all entry from minHeap and add to result list  
 *    
 * Time Complexity: O(N + N * logk)
 * Space Complexity: O(N)
 */

public class TopKFrequentNumbers {
	public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int num : nums)
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>((e1, e2) ->
																e1.getValue() - e2.getValue());
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		List<Integer> topNumbers = new ArrayList<>(k);
		while(!minHeap.isEmpty())
			topNumbers.add(minHeap.poll().getKey());
		
		return topNumbers;
	}

	public static void main(String[] args) {
		List<Integer> result = findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);	//12, 11
		System.out.println("Here are the K frequent numbers: " + result);

		result = findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);	//12,11
		System.out.println("Here are the K frequent numbers: " + result);
	}
}
