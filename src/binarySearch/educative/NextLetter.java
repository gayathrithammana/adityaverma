package binarySearch.educative;

/**
 * Leetcode 744. Find Smallest Letter Greater Than Target
 * given array is a circular list 
 * 
 * Same as ceil 
 * 1. apply binary search 
 * 2. return start % n
 * 
 * Time Complexity : O(logN) 
 * Space Complexity : 1
 */
public class NextLetter {
	public static char searchNextLetter(char[] letters, char key) {
		int n = letters.length;
		if(key < letters[0] || key > letters[n-1])
			return letters[0];
		
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(key < letters[mid])
				end = mid - 1;	//search in first half
			else
				start = mid + 1;	//search in second half
			
		}
		
		//instead of returning start return start % n as it is ciruclar
		return letters[start % n];	
	}

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));	//h
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));	//c
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));	//a
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));	//a
	}
}
