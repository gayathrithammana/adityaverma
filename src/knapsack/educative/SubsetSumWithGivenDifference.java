package knapsack.educative;

/**
 * Aditya
 * 
 * Problem1: 
 * Count no.of subsets sum and thier difference is equal to given diff 
 * Ex: nums = {1, 1, 2, 3}, diff=1
 *          -> 1+3=4 and 1+2=3
 *          -> 4-3=1 
 * S1 + S2 = S
 * S1 - S2 = diff
 * S1 = (S + diff)/2
 * 
 * Find count using Count of subsets for sum S1
 * 
 * Problem2: 
 * Leetcode 494. Target Sum
 * You are given a set of positive numbers and a target sum ‘S’. 
 * Each number should be assigned either a ‘+’ or ‘-’ sign. 
 * We need to find the total ways to assign symbols to make the sum of the numbers equal to the target ‘S’.
 * 
 * i.e., S1 = sum of +ve integers
 * 		 S2 = sum of -ve integers
 * 
 * S1 + (-S2) = target which is nothing but above problem 
 */

public class SubsetSumWithGivenDifference {
	public static int count(int[] num, int diff) {
		int sum = 0;
		for(int i:num)
			sum += i;
		
		int tempSum = (diff + sum) / 2;
		
		return CountOfSubsets.countSubsets(num, tempSum);
	}

	public static void main(String[] args) {
		int[] num = { 1, 1, 2, 3 };			//3
		System.out.println(count(num, 1));
	}
}
