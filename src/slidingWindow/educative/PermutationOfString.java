package slidingWindow.educative;

import java.util.HashMap;
import java.util.Map;

/***
 * Time Complexity O(N + M)
 * Space Complexity O(M)
 */
public class PermutationOfString {
	
	private static boolean checkIfPermutationExists(String str, String pattern) {
		int len = str.length();
		int k = pattern.length();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<k;i++) {
			char charI = pattern.charAt(i);
			map.put(charI, map.getOrDefault(charI, 0) + 1);
		}
		
		int i = 0;
		int j = 0;
		int matched = map.size();
		
		while(j < len) {
			
			char keyJ = str.charAt(j);
			if(map.containsKey(keyJ)) {
				map.put(keyJ, map.get(keyJ) - 1);
				
				if(map.get(keyJ) == 0)
					matched--;
			}
			
			if(j-i+1 < k)
				j++;
			else if (j-i+1 == k) {
				if(matched == 0)	//matched all chars in map. if matched need to not continue rest of the program
					return true;
				
				//otherwise slide the window
				//revert cals for i before sliding window
				char keyI = str.charAt(i);
				if(map.containsKey(keyI)) {
					map.put(keyI, map.get(keyI) + 1);
					
					if(map.get(keyI) == 1)
						matched++;
				}
				
				i++;
				j++;
			}
			
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkIfPermutationExists("oidbcaf", "abc"));	//bca - true
		System.out.println(checkIfPermutationExists("odicf", "dc"));	//false
		System.out.println(checkIfPermutationExists("bcdxabcdy", "bcdyabcdx"));	//true
		System.out.println(checkIfPermutationExists("aaacb", "abc"));	//acb - true
	}

}
