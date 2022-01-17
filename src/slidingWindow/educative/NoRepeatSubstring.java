package slidingWindow.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity O(N) - length of string
 * Space Complexity O(K) - the number of distinct characters in the input string.(K <= N). 
 * Worst case we can expect a fixed set of characters in the input string 26 english chars,
 * we can say that the algorithm runs in fixed space O(1)
 */

/**
 * longest substring with all unique chars
 * 80% same as k unique chars question
 * k = j - i + 1 and some tweeks
 */
//condition: all unique chars

public class NoRepeatSubstring {
	
	//from educative
	private static int longest1(String str) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;
		int maxSize = 0;
		
		while(j < str.length()) {
			
			char keyJ = str.charAt(j);	//right char
			
			// if the map already contains the 'keyJ', shrink the window from the beginning so that
		    // we have only one occurrence of 'keyJ'
			if(map.containsKey(keyJ)) {
				// this is tricky; in the current window, we will not have any 'keyJ' after its previous index
		        // and if 'i' is already ahead of the last index of 'keyJ', we'll keep 'i'
				// EX: abccdea - we need to use i instead of map.get(keyJ) + 1 for last 'a'
				i = Math.max(i, map.get(keyJ) + 1);
			}
			
			map.put(keyJ, j);	// insert the 'keyJ' into the map
			
			maxSize = Math.max(maxSize, j-i+1); // remember the maximum length so far
			
			j++;
			
		}
		
		return maxSize;
	}
	
	//from Aditya Verma
	private static int longest(String str) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;
		int maxSize = 0;
		
		while(j < str.length()) {
			char keyJ = str.charAt(j);
			if(map.containsKey(keyJ))
				map.put(keyJ, map.get(keyJ) + 1);
			else
				map.put(keyJ, 1);
			
			if(map.size() == j-i+1) {
				maxSize = Math.max(maxSize, j-i+1);
				j++;
			}
			else if(map.size() < j-i+1) {
				while(map.size() < j-i+1) {	//remove cals for i
					char keyI = str.charAt(i);
					if(map.containsKey(keyI))
						map.put(keyI, map.get(keyI) - 1);
					
					if(map.get(keyI) == 0)
						map.remove(keyI);
					
					i++;
				}
				j++;
			}
		}
		
		return maxSize;
	}
	
	public static void main(String[] args) {
		System.out.println(longest1("aabccbb"));	//abc=3
		System.out.println(longest1("abbbb"));	//ab=2
	}

}
