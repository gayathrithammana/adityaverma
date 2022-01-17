package subsets.educative;

import java.util.ArrayList;
import java.util.List;

/** Leetcode 320 - Generalized Abbreviation
 * 
 * similar to Generate Parentheses
 * create recursive tree and find solution
 * 
 *  1. start with empty output string
 *  2. for op1 suffix _
 *     for op2 suffix with input char at given index
 *  3. solve both recursively
 *  4. when index == ip length add to temp list and return
 *  5. replace _ in temp list with numbers - to-do find better solution 
 *  
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */
public class UniqueGeneralizedAbbreviations {
	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		solve(word, 0, "", list);
		
		//iterate result and replace continuous _ with numbers
		for(String str : list) {
			int noOf_ = 0;
			//replace _ for each string
			StringBuilder temp = new StringBuilder(str);
			int startIndex = -1;
			for(int i=0;i<str.length();i++) {
				
				
				if(str.charAt(i) == '_') {
					noOf_++;
					if(startIndex == -1)
						startIndex = i;
					
					if(i == str.length() - 1) {
						temp.replace(temp.indexOf("_"), temp.lastIndexOf("_") + 1, (noOf_ + ""));
					}
				}
				else {
					if(noOf_ > 0) {
						temp = temp.replace(startIndex, i, (noOf_ + ""));
						noOf_ = 0;
						startIndex = -1;
					}
				}
					
			}
			
			result.add(temp.toString());
		}
		return result;
	}

	private static void solve(String ip, int index, String op, List<String> list) {
		if(index == ip.length()) {
			list.add(op);
			return;
		}
		
		char currentChar = ip.charAt(index);
		String op1 = op;
		String op2 = op;
		
		//for op1 suffix with _
		op1 += "_";
		
		//for op2 if last last char is _ we need to add number and currentChar
		//else currentChar
		int noOf_ = 0;
		for(int i=0;i<ip.length();i++) {
			if(ip.charAt(i) == '_')
				noOf_++;
		}
		if(noOf_ > 0) {
			op2 += noOf_ + currentChar; 
		} else
			op2 += currentChar;
		
		solve(ip, index+1, op1, list);
		solve(ip, index+1, op2, list);
	}

	public static void main(String[] args) {
//		List<String> result = generateGeneralizedAbbreviation("BAT");
//		System.out.println("Generalized abbreviation are: " + result);

		List<String> result = generateGeneralizedAbbreviation("code");
		System.out.println("Generalized abbreviation are: " + result);
	}
}
