package recursion;

public class PrintSubsetsWithSpaces {
	private static void solve(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		//choice1: include space
		op1 += " "+ ip.charAt(0);
		
		//choice2: dont include space
		op2 += ip.charAt(0);
		ip = ip.substring(1);
		
		solve(ip, op1);	
		solve(ip, op2);	
		
		
		
	}

	public static void main(String[] args) {
		String str = "abc";
		String input = str.substring(1);
		String output = ""+ str.charAt(0);
		solve(input, output);
	}
}
