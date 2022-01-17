package fastAndSlowPointers.educative;

/**
 * Time Complexity O(logN)
 * Space Complexity O(1)
 */
public class HappyNumber {
	
	private static boolean isHappy(int num) {
		int slow = num;
		int fast = num;
		
		do {
			slow = findSumOfSquares(slow);
			fast = findSumOfSquares(findSumOfSquares(fast));
		} while(slow != fast);
		
		return slow == 1;
	}

	private static int findSumOfSquares(int num) {
		int sum = 0;
		int digit = 0;
		
		while(num > 0) {
			digit = num % 10;
			sum += digit * digit;
			num /= 10;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		/**
		2^2 + 3^2 = 13
		1^2 + 3^2 = 10
		1^2 + 0^2 = 1 
		**/
		System.out.println(isHappy(23));	//true
		System.out.println(isHappy(12));	//false
		
	}

}
