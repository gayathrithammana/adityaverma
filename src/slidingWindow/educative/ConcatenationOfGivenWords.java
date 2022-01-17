package slidingWindow.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenationOfGivenWords {

	private static List<Integer> findAllSubstrings(String str, List<String> words) {
		
		List<Integer> startIndexes = new ArrayList<Integer>();
		int wordLength = words.get(0).length();
		int i = 0;
		int j = 0;
		
		
		//map with word and count(initially 1 . if matched reduce to 0)
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String oneStr : words) {
			map.put(oneStr, 1);
		}
		
		int matched = 0;
		
		while(j <= str.length() - wordLength) {
			String strJ = str.substring(j, j+wordLength);
			//find if current string is in map
			if(map.containsKey(strJ)) {
				//if value is 1 reduce it to 0 
				//and increase matched count
				if(map.get(strJ) == 1) {
					map.put(strJ, 0);
					matched++;
				}
				else {	//if same word again comes we need to shrink window from left
					//for example catcat 
					map.put(strJ, 1);
					i += wordLength;
				}
			}
			
			if(matched == words.size()) {
				startIndexes.add(i);
				
				//revert cals for i before sliding
				String strI = str.substring(i, i+wordLength);
				if(map.containsKey(strI)) {
					map.put(strI, 1);
					matched--;
				}
				
				i += wordLength;
			}
				
			
			j += wordLength;
		}
		
		return startIndexes;
	}
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("cat");
		words.add("fox");
		System.out.println(findAllSubstrings("catfoxcat", words));
		System.out.println(findAllSubstrings("catcatfoxfox", words));
	}

}
