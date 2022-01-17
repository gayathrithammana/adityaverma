package twoPointers.educative;

public class CompareStringContainingBackspaces {
	
	//from youtube(https://www.youtube.com/watch?v=vgog1EuEJYQ)
	private static boolean compareStrings(String S, String T) {
		int index1 = S.length() - 1;
		int index2 = T.length() - 1;
		
		int skip1 = 0;
		int skip2 = 0;
		
		while(index1 >=0 || index2 >= 0) {
			
			while(index1 >= 0) {
				if(S.charAt(index1) == '#') {
					skip1++;
					index1--;
				} else if(skip1 > 0) {
					index1--;
					skip1--;
				} else
					break;
			}
			
			while(index2 >= 0) {
				if(T.charAt(index2) == '#') {
					skip2++;
					index2--;
				} else if(skip2 > 0) {
					index2--;
					skip2--;
				} else
					break;
			}
			
			//after applying skips - if remaining chars are not equal
			if(index1 >= 0 && index2 >=0 && S.charAt(index1) != T.charAt(index2)) {
				return false;
			}
			
			//if lengths are differet
			if((index1 >= 0) != (index2 >= 0))
				return false;
				
			
			index1--;
			index2--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(compareStrings("xy#z", "xzz#"));	//true
		System.out.println(compareStrings("xy#z", "xyz#")); //false
		System.out.println(compareStrings("xp#", "xyz##")); //true
		System.out.println(compareStrings("xywrrmp", "xywrrmu#p")); //true
		System.out.println(compareStrings("bxj##tw", "bxj###tw")); //false
	}
	
	//my initital solution
	private static boolean compareStrings1(String str1, String str2) {
		String resultStr1 = removeBackspaces(str1);
		String resultStr2 = removeBackspaces(str2);
		
		if(resultStr1.equals(resultStr2))
			return true;
		return false;
	}
	
	private static String removeBackspaces(String str) {
		StringBuffer result = new StringBuffer();
		int i = str.length() - 1;
		int j = str.length() - 1;
		
		while(i >= 0 && j >=0 ) {
			if(i == j && str.charAt(i) != '#' ) {
				result.insert(0, str.charAt(i));
				i--;
				j--;
			}
			else if(str.charAt(i) == '#'){
				while(str.charAt(j) == '#')
					j--;
				
				j -= (i - j);
				i = j;
			}
				
		}
		return result.toString();
	}

}
