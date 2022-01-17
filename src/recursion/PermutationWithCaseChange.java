package recursion;

/**
 * 784. Letter Case Permutation 
 * 
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * solve using Aditya Verma videos
 * 1. take first char from input 
 * 2. if char is alphabet convert op1 to op + lowercase(firstchar)
 *    - 					   and  op2 to op + uppercase(firstchar)
 *    - remove firstchar from input
 *    - solve recursively
 * 3. if char is not alphabet append first char to op
 *    - remove firstchar from input
 *    - solve recursively
 * 4. if input length == 0 add output to result 
 * 
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(N * 2^N)
 */
public class PermutationWithCaseChange {
	private static void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		//choice1: no upper case
		op1 += ip.charAt(0);
		
		//choice2: upper case
		op2 += Character.toUpperCase(ip.charAt(0));
		
		ip = ip.substring(1);
		
		solve(ip, op1);	
		solve(ip, op2);	
	}

	public static void main(String[] args) {
		String input = "ab";
		String output = "";
		solve(input, output);
	}
}
