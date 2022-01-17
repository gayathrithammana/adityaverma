package matrixChainMultiplication;

public class ScramledString {
	
	public static boolean solve(String a, String b) {
		if(a.length() != b.length())
			return false;
		if((a.equals("") && b.equals("")) || a.equals(b))
			return true;
		if(a.length() <= 1)
			return false;
		
		int n = a.length();
		boolean flag = false;
		
		for(int i=1; i<n; i++) {
			boolean condition1 = solve(a.substring(0, i), b.substring(n-i)) &&
								 solve(a.substring(i, n), b.substring(0, n-i));
			
			boolean condition2 = solve(a.substring(0, i), b.substring(0, i)) &&
								 solve(a.substring(i, n), b.substring(i, n));
			
			if(condition1 || condition2) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	public static void main(String[] args) {
		String a = "great";
		String b = "grate";
		System.out.println(solve(a, b));
	}

}
