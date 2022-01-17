package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

	public static int count(String str, String pattern) {
		int i = 0;
		int j = 0;
		
		//map to find char count for each char
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;
		
		for(char c : pattern.toCharArray()) {
			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		
		//easy to find if counts matched for each character
		//then we can increment ans
		int count = map.size();
		
		while (j < str.length()) {
			
			char keyJ = str.charAt(j);
			
			if(map.containsKey(keyJ)) {
				map.put(keyJ, map.get(keyJ) - 1);
			
				if(map.get(keyJ) == 0)
					count--;
			}
			
			if (j - i + 1 < pattern.length()) 
				j++;
			else if (j - i + 1 == pattern.length()) {
				if(count == 0)
					ans++;
				
				//iteration continues as we need to keep track of all possible anagrams
				char keyI = str.charAt(i);
				//before sliding revert calculations of i
				if(map.containsKey(keyI)) {
					map.put(keyI, map.get(keyI) + 1);
				
					if(map.get(keyI) == 1)
						count++;
				}
				
				//slide window
				i++;
				j++;
			}
		}
		
		return ans;

	}

	public static void main(String[] args) {
//		System.out.println(count("aabaabaa", "aaba")); //aaba, abaa, aaba, abaa = 4
		System.out.println(count("odicf", "dc"));
	}


}
