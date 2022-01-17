package slidingWindow.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * In each window we can replace k chars with most repeating chars and
 * take max window size as answer
 * 
 * 1. iterate each char and create a map of char counts 
 * 2. keep track of maxRepeatingLetterCount in every iteration 
 * 3. when current window size - maxRepeatingLetterCount > k 
 *    remove cals for i and shrink 
 * 4. cals max using window size
 * 
 * Time Complexity O(N)
 * Space Complexity O(26) -> O(1)
 */

public class LongestSubstringWithSameLetterAfterReplace {

	private static int longest(String str, int k) {

		int maxRepeatingLetterCount = 0;
		int maxSize = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;

		while (j < str.length()) {
			char keyJ = str.charAt(j);
			map.put(keyJ, map.getOrDefault(keyJ, 0) + 1);

			maxRepeatingLetterCount = Math.max(maxRepeatingLetterCount, map.get(keyJ));

			// current window size is from windowStart to windowEnd, overall we have a letter which is
			// repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
			// repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
			// if the remaining letters are more than 'k', it is the time to shrink the window as we
			// are not allowed to replace more than 'k' letters

			if (j - i + 1 - maxRepeatingLetterCount > k) {
				// shrink window and remove cal for i
				char keyI = str.charAt(i);
				map.put(keyI, map.get(keyI) - 1);
				i++;
			}

			maxSize = Math.max(maxSize, j - i + 1);

			j++;
		}

		return maxSize;
	}

	public static void main(String[] args) {
		System.out.println(longest("aabccbb", 2)); // bccbb -> bbbbb -> 5
		System.out.println(longest("abbcb", 1)); // bbcb -> bbbb -> 4
		System.out.println(longest("abccde", 1)); // bcc/ccd -> ccc -> 3
	}

}
