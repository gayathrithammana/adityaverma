package recursion;

public class PrintSubsetsOfString {
	
	private static void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		//choice1: not taking char - no change to op1
		//choice2: taking char - append char to op2 
		op2 += ip.charAt(0);
		ip = ip.substring(1);
		
		solve(ip, op1);	//decision 1: not taking char
		solve(ip, op2);	//decision 2: taking char
		
		
		
	}

	public static void main(String[] args) {
		String input = "ab";
		String output = "";
		solve(input, output);	//"", b, a, ab
	}
}
