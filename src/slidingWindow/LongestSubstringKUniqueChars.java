package slidingWindow;
/**
 * 1. longest substring with k no.of unique chars
 * 2. pick toys problem
 * 3. Fruits into Baskets (given 2 baskets the goal is to put maximum number of fruits in each basket.)
 */
//condition: k unique chars 

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUniqueChars {
	public static int longest(String str, int k) {
		int i = 0;
		int j = 0;
		
		int maxSize = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		while (j < str.length()) {
			
			char keyJ = str.charAt(j);
			map.put(keyJ, map.getOrDefault(keyJ, 0) + 1);	//calculation
				
			if (map.size() < k) 		//map.size() = no.of unique chars
				j++;
			else if (map.size() == k) {
				maxSize = Math.max(map.size(), j - i + 1);
				j++;
			}
			else if(map.size() > k) {
				while(map.size() > k) {
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
		System.out.println(longest("aabacbebebe", 3)); //cbebebe = [ length = 7, unique chars c, b ,e ]
	}
}
