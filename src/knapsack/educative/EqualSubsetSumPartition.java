package knapsack.educative;

/**
 * Leetcode 416. Partition Equal Subset Sum
 * 
 * Aditya
 * 
 * Same as subset sum. We just need to find total sum and find if there is a
 * pair with total sum / 2
 * 
 * Time Complexity: O(N * S/2)
 * Space Complexity: O(N * S/2)
 */
public class EqualSubsetSumPartition {
	 public static boolean canPartition(int[] num) {
		 int sum = 0;
		 for(int i=0;i<num.length;i++)
			 sum += num[i];
		 
		 if(sum %2 != 0)	//if sum is odd we cant have two subsets with same total
			 return false;
		 
		 return SubsetSum.canPartition(num, sum / 2);
	 }
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4 };				//true {1, 4} & {2, 3}
		System.out.println(canPartition(num));
		num = new int[] { 1, 1, 3, 4, 7 };		//true {1, 3, 4} & {1, 7}
		System.out.println(canPartition(num));
		num = new int[] { 2, 3, 4, 6 };			//false 
		System.out.println(canPartition(num));	
	}
}
