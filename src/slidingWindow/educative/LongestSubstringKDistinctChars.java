package slidingWindow.educative;

import java.util.HashMap;
import java.util.Map;

/***
 * Time Complexity O(N)
 * Space Complexity O(K)
 */

/**
 * 1. longest substring with k no.of unique chars
 * 2. pick toys problem
 * 3. Fruits into Baskets (given 2 baskets the goal is to put maximum number of fruits in each basket.)
 */

public class LongestSubstringKDistinctChars {

	private static int longest(String str, int k) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;
		int maxSize = 0;

		while (j < str.length()) {
			
			char keyJ = str.charAt(j);
			map.put(keyJ, map.getOrDefault(keyJ, 0) + 1);	//calculation

			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				maxSize = Math.max(maxSize, j - i + 1);
				j++;
			} else {
				while (map.size() > k) {
					// remove cal of i
					char keyI = str.charAt(i);
					if (map.containsKey(keyI)) {
						map.put(keyI, map.get(keyI) - 1);

						if (map.get(keyI) == 0)
							map.remove(keyI);
						
						i++;
					}
					j++;
				}
			}
		}

		return maxSize;
	}

	public static void main(String[] args) {
		System.out.println(longest("araaci", 2));	//araa{unique chars a, r},length=4
	}

}
