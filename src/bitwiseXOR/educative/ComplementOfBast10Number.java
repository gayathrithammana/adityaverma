package bitwiseXOR.educative;

/**
 * Leetcode 1009. Complement of Base 10 Integer
 * 
 * Derived
 * 
 * number ^ complement = all_bits_set
 * number ^ number ^ complement = number ^ all_bits_set
 * 0 ^ complement = number ^ all_bits_set
 * complement = number ^ all_bits_set
 * 
 * 1. Find no.of bits of given number
 * 2. Find number with all bits set Math.pow(2, bits) - 1
 * 3. XOR of step2 and given number
 * Time Complexity : O(b) - no.of bits required to store given number
 * Space Complexity : 1
 */
public class ComplementOfBast10Number {
	public static int bitwiseComplement(int num) {
		if(num == 0)
			return 1;
		// step 1.count bits in num
		int bits = 0;
		int temp = num;
		while (temp > 0) {
			bits++;
			temp = temp >> 1;
		}
		
		//step 2. find number with all bits set to 1
		int noWithAllBits1 = (int) (Math.pow(2, bits) - 1);
		
		//step3. find XOR
		return num ^ noWithAllBits1;
	}

	public static void main(String[] args) {
		System.out.println("Bitwise complement is: " + bitwiseComplement(8));	//7
		System.out.println("Bitwise complement is: " + bitwiseComplement(10));	//5
	}
}
