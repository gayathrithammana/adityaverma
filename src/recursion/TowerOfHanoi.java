package recursion;

public class TowerOfHanoi {

	private static void solve(char s, char d, char h, int n) {
		if(n == 1) {
			System.out.println("move plate " + n + " from " + s + " to " + d);
			return;
		}
		
		//move n-1 plates from from s to h
		solve(s, h, d, n-1);
		
		//move rest of one plate from s to d
		System.out.println("move plate " + n + " from " + s + " to " + d);
		
		//move n-1 plates from h to d
		solve(h, d, s, n-1);
	}

	public static void main(String[] args) {
		solve('s', 'd', 'h', 3);
	}

}
