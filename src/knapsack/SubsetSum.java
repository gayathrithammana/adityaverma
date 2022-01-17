package knapsack;

import java.util.ArrayList;
import java.util.List;

//1. find if subset exists which sums up to given target
// 2. Partiotion equal subset sum
// 3. count no.of subsets 
// https://www.youtube.com/watch?v=K20Tx8cdwYY
/**
 * @author Gaya 3
 *	truth value = tv by excluding new value + tv by including new values
 */
public class SubsetSum {
	public static boolean exists(int[] arr, int sum, int n) {
		boolean t[][] = new boolean[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = false;
				if(j == 0)
					t[i][j] = true;
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] 	//including
								||
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if arr[i-1] > j copy from previous
				}
			}
		}
		
		System.out.println("  		      0 1 2 3 4 5 6 7 8");
		for(int i=0;i<=n;i++) { 
			if(i == 0)
				System.out.print(0 + " 		      ");
			else {
				System.out.print(arr[i - 1] + "(included " + i + " elements)");
			}
			for(int j=0;j<=sum;j++) {
				if(t[i][j] == true)
					System.out.print("T" + " ");
				else
					System.out.print("F" + " ");
			}
			System.out.println();
		}
		
		return t[n][sum];
	}
	
	 public static boolean canPartition(int[] nums) {
	        int sum = 0;
	        for(int i=0;i<nums.length;i++){
	            sum += nums[i];
	        }
	        
	        if(sum % 2 != 0)
	            return false;
	        else{
	            return exists(nums, sum /2, nums.length);
	        }
	    }
	
	public static int count(int[] arr, int sum, int n) {
		int t[][] = new int[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = 0;
				if(j == 0)
					t[i][j] = 1;
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] 	//including
								+ 
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if arr[i-1] > j copy from previous
				}
			}
		}
		return t[n][sum];
	}
	
	public static int minimumSubsetSum(int[] arr, int n) {
		int sum = 0;
		for(int i=0;i<n;i++)
			sum += arr[i];
		
		boolean t[][] = new boolean[n+1][sum+1];
		//initialization
		for(int i=0;i<=n;i++) { 
			for(int j=0;j<=sum;j++) {
				if(i == 0)
					t[i][j] = false;
				if(j == 0)
					t[i][j] = true;
			}
		}
		for(int i=1;i<=n;i++) { 
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] 	//including
								||
							  t[i-1][j]; 			//excluding
					
				} else { 							
					t[i][j] = t[i-1][j];			//if arr[i-1] > j copy from previous
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<sum/2 + 1;i++) {
			if(t[n][i] == true)
				list.add(i);
		}
		
		int mn = Integer.MAX_VALUE;
		for(int i=0;i<list.size();i++) {
			mn = Math.min(mn, sum - 2 * list.get(i));
		}
		
		return mn;
	}
	
	public static void main(String[] args) {
//		System.out.println(exists(new int[] {1, 2 ,5, 7}, 8, 4));
//		System.out.println(canPartition(new int[] {1, 5 ,11, 5})); //{1,5,5} , {11}
//		System.out.println(count(new int[] {2, 3 ,5, 6, 8, 10}, 10, 6));
		System.out.println(minimumSubsetSum(new int[] {1, 6, 11, 5}, 4));
		System.out.println(minimumSubsetSum(new int[] {1, 2, 7}, 3));
	}
}
