package slidingWindow.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * same as PermutationOfString
 * just save indexes of i
 * 
 * Time Complexity O(N + M)
 * Space Complexity O(M)
 */

public class IndexesOfMatchingAnagrams{

	private static List<Integer> anagramStartIndex(String str, String pattern) {
		List<Integer> startIndexes = new ArrayList<Integer>();

		int len = str.length();
		int k = pattern.length();

		// frequency map
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < k; i++) {
			char keyI = pattern.charAt(i);
			map.put(keyI, map.getOrDefault(keyI, 0) + 1);
		}

		int matched = map.size();
		int i = 0;
		int j = 0;
		while (j < len) {
			char keyJ = str.charAt(j);
			if (map.containsKey(keyJ)) {
				map.put(keyJ, map.get(keyJ) - 1);

				if (map.get(keyJ) == 0)
					matched--;
			}

			if (j-i+1 < k)
				j++;
			else if (j-i+1 == k) {
				if (matched == 0)
					startIndexes.add(i);
				
				//iteration continues as we need to keep track of all possible anagrams
				// revert cals for i before sliding
				char keyI = str.charAt(i);
				if (map.containsKey(keyI)) {
					map.put(keyI, map.get(keyI) + 1);

					if (map.get(keyI) == 1)
						matched++;
				}

				i++;
				j++;

			}
		}

		return startIndexes;
	}

	public static void main(String[] args) {
		List<Integer> list = anagramStartIndex("ppqp", "pq");	//pq=1, qp=2
		for (int i : list)
			System.out.println(i);
		
		list = anagramStartIndex("abbcabc", "abc");	//bca=2, cab=3, abc=4
		for (int i : list)
			System.out.println(i);
	}

}
