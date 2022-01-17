package topKElements.educative;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode 451. Sort Characters By Frequency
 * 
 * Given a string, sort it based on the decreasing frequency of its characters.
 * 
 * Use maxHeap to store all the elements.So that most freq elements will be at top when we pop
 * 
 * 1. create a freq map
 * 2. add all map entries to maxHeap
 * 3. pop all entry one by one(which were sorted in descending by frequency)
 *   - add to result string
 *    
 * Time Complexity: O(N * logN) - in worst case if all are unique
 * Space Complexity: O(N)
 */
public class FrequencySort {
	public static String sortCharacterByFrequency(String str) {
		int n = str.length();
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for(int i=0; i<n; i++) {
			Character currentChar = str.charAt(i);
			freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1, e2) ->
																e2.getValue() - e1.getValue());
		
		maxHeap.addAll(freqMap.entrySet());
		
		StringBuilder resultStr = new StringBuilder(n);
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for(int i=0;i<entry.getValue();i++)
				resultStr.append(entry.getKey());
		}
		return resultStr.toString();
	}

	public static void main(String[] args) {
		String result = sortCharacterByFrequency("Programming");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);	//rrggmmPiano

		result = sortCharacterByFrequency("abcbab");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);	//bbbaac
	}
}
