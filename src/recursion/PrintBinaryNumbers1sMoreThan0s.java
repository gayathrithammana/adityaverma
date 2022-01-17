package recursion;

public class PrintBinaryNumbers1sMoreThan0s {
	
	private static void solve(int ones, int zeroes, int n, String op) {
		if(n == 0) {
			System.out.println(op);
			return;
		}
		
		//add ones always
		String op1 = op + "1";
		solve(ones+1, zeroes, n-1, op1);
		
		//we can accommodate zeroes only if ones > zeroes
		if(ones > zeroes) {
			String op2 = op + "0";
			solve(ones, zeroes+1, n-1, op2);
		} 
		
	}

	public static void main(String[] args) {
		int n = 3;
		int ones = 0;
		int zeroes = 0;
		String output = "";
		solve(ones, zeroes, n, output);
	}

}
