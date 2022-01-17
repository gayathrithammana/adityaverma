package topKElements.educative;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode problem: 358 Rearrange String k Distance Apart
 * 
 * Given a string and a number ‘K’, find if the string can be rearranged such that 
 * the same characters are at least ‘K’ distance apart from each other.
 * 
 * Use MaxHeap 
 * 1. create freq map 
 * 2. add all entries to maxheap 
 * 3. while maxheap is not empty 
 *   - pop top entry and add its key to result and reduce the freq 
 *   - add entry to queue
 * 4. when queue size reaches k pop entry from queue 
 *   - and to maxHeap back if the freq is > 0 
 * 
 * 
 * Time Complexity: O(NlogN) 
 * Space Complexity: O(N)
 */

public class ReArrangeStringKDistancesApart {

	public static String reorganizeString(String str, int k) {
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		maxHeap.addAll(freqMap.entrySet());

		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuffer s = new StringBuffer();

		while (!maxHeap.isEmpty()) {
			// removed entry
			Map.Entry<Character, Integer> current = maxHeap.poll();

			// append to resultant string
			s.append(current.getKey());
			current.setValue(current.getValue() - 1);
			queue.offer(current);

			// add it back to heap as we removed this entry in above step
			// when queue reaches size K
			if (queue.size() == k) {
				Map.Entry<Character, Integer> entry = queue.poll();
				if (entry.getValue() > 0)
					maxHeap.offer(entry);
			}

		}
		return s.length() == str.length() ? s.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println("Reorganized string: " + reorganizeString("mmpp", 2));	//pmpm
		System.out.println("Reorganized string: " + reorganizeString("Programming", 3));	//rgmPrgmiano
		System.out.println("Reorganized string: " + reorganizeString("aab", 2));	//aba
		System.out.println("Reorganized string: " + reorganizeString("aappa", 3));	//""
	}

}
