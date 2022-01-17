package slidingWindow;

/**
 * longest substring with all unique chars
 * 80% same as k unique chars question
 * k = j - i + 1 and some tweeks
 */
//condition: all unique chars

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAllUniqueChars {
	public static int longest(String str) {
		int i = 0;
		int j = 0;
		
		int maxSize = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		while (j < str.length()) {
			
			char keyJ = str.charAt(j);
			
			map.put(keyJ, map.getOrDefault(keyJ, 0) + 1);	//calculation
			
				
			if (map.size() == j - i + 1) {			    //check if all chars in window are unique 
				maxSize = Math.max(maxSize, j - i + 1);	//max - longest and unique chars(map.size())
				j++;
			}
			else if(map.size() < j - i + 1) {
				while(map.size() < j - i + 1) {
					//remove cal of i
					char keyI = str.charAt(i);
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
//		System.out.println(longest("pwwkew")); //pwwkew = [ length = 3, substring wke ]
		System.out.println(longest("nfpdmpi")); //nfpdmpi = [ length = 5, substring nfpdm ]
	}
}
