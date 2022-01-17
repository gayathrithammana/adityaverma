package slidingWindow.educative;

/**
 * In each window we can replace k no.of s with 1s
 * Keep track of maxOnesCount.
 * if(current window size - maxOnesCount would give maxZeroesCount) > k
 * shrink window 
 * 
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class LongestSubarrayWithOnesAfterReplace {

	private static int longest(int[] arr, int k) {

		int i = 0;
		int j = 0;
		int maxSize = 0;
		int maxOnesCount = 0;

		while (j < arr.length) {
			if (arr[j] == 1)
				maxOnesCount++;
			
			//we can have a window with 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
			// now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
			// are not allowed to replace more than 'k' Os
			if (j - i + 1 - maxOnesCount > k) {
				// before moving i from left to right check if value at i is 1.
				// If it is 1 reduce maxOnescount

				if (arr[i] == 1) // remove cals for i
					maxOnesCount--;

				i++;
			}

			maxSize = Math.max(maxSize, j - i + 1);

			j++;
		}

		return maxSize;
	}

	public static void main(String[] args) {
		System.out.println(longest(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2)); // 6
	}

}
