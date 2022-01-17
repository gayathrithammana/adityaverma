package slidingWindow.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=eS6PZLjoaq8
 * 
 * Time Complexity O(N + M)
 * Space Complexity O(N + M)
 */

public class SmallestWindowContainingSubstring {

	public static String findSubstring(String str, String pattern) {
	    int i = 0, j = 0;
	    int matched = 0;
	    int minLength = str.length() + 1;
	    int subStrStart = 0;
	    
	    Map<Character, Integer> map = new HashMap<>();
	    for (char chr : pattern.toCharArray())
	      map.put(chr, map.getOrDefault(chr, 0) + 1);

	    // try to extend the range [windowStart, windowEnd]
	    while(j < str.length()) {
	    	
	      char keyJ = str.charAt(j);
	      if (map.containsKey(keyJ)) {
	        map.put(keyJ, map.get(keyJ) - 1);
	        if (map.get(keyJ) >= 0) // count every matching of a character
	          matched++;
	      }

	      // shrink the window if we can, finish as soon as we remove a matched character
	      while (matched == pattern.length()) {
	        if (j - i + 1 < minLength) {
	          minLength = j - i + 1;
	          subStrStart = i;
	        }
	        
	        //revert cals for i before sliding window
	        char keyI = str.charAt(i);
	        if (map.containsKey(keyI)) {
	          if (map.get(keyI) == 0)
	            matched--;
	          map.put(keyI, map.get(keyI) + 1);
	        }
	        
	        i++;
	      }
	      
	      j++;
	    }

	    return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
	  }

	  public static void main(String[] args) {
//	    System.out.println(findSubstring("aabdec", "abc"));	//abdec
//	    System.out.println(findSubstring("abdbca", "abc"));	//bca
//	    System.out.println(findSubstring("adcad", "abc"));  //""
	    System.out.println(findSubstring("azjskfzts", "sz"));  //"zjs"
	  }

}
