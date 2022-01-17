package topKElements.educative;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode problem: 767. Reorganize String
 * 
 * Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
 * 
 * Use MaxHeap
 * 1. create freq map
 * 2. add all entries to maxheap
 * 3. while maxheap is not empty
 *    - pop top entry and add its key to result and reduce the freq
 *    - in next loop check the freq and add back to maxheap
 * 4. return the result string if its length is same as given string 
 *    - else return empty 
 *    
 *    
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N) 
 */

public class ReArrangeString {
	public static String rearrangeString(String str) {
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			char currentChar = str.charAt(i);
			freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1, e2) -> e2.getValue() - e1.getValue());
		
		maxHeap.addAll(freqMap.entrySet());
		
		StringBuffer s = new StringBuffer();
		Map.Entry<Character, Integer> prev = null;
		
		while(!maxHeap.isEmpty()) {
			//removed entry
			Map.Entry<Character, Integer> current = maxHeap.poll();	
			
			//add it back to heap as we removed this entry in above step
			if(prev != null && prev.getValue() > 0)	
				maxHeap.offer(prev);
			
			//append to resultant string
			s.append(current.getKey());
			current.setValue(current.getValue() - 1);
			prev = current;
				
		}
		return s.length() == str.length() ? s.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println("Rearranged string: " + rearrangeString("aappp"));	//papap
		System.out.println("Rearranged string: " + rearrangeString("Programming"));	//rgmrgmPiano
		System.out.println("Rearranged string: " + rearrangeString("aapa"));	//""
		System.out.println("Rearranged string: " + rearrangeString("aapatwx"));	//axaptaw
	}
}
