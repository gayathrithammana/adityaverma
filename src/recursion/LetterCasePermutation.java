package recursion;

//Given a string, find all of its permutations preserving the character sequence but changing case.
public class LetterCasePermutation {
	private static void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		if(Character.isAlphabetic(ip.charAt(0))) {
			String op1 = op;
			String op2 = op;
			
			//choice1: lower case
			op1 += Character.toLowerCase(ip.charAt(0));
			
			//choice2: upper case
			op2 += Character.toUpperCase(ip.charAt(0));
			
			ip = ip.substring(1);
			
			solve(ip, op1);	
			solve(ip, op2);	
			
		}	else {
			String op1 = op + ip.charAt(0);
			ip = ip.substring(1);
			solve(ip, op1);
		}
	}

	public static void main(String[] args) {
		String input = "a1B1";
		String output = "";
		solve(input, output);
	}
}
