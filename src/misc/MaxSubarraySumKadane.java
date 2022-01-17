package misc;

public class MaxSubarraySumKadane {
	
	public static int maxSum(int[] arr) {
		int n = arr.length;
		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			localMax = Math.max(arr[i], arr[i] + localMax);
			if(localMax > globalMax)
				globalMax = localMax;
		}
		return globalMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})); //{4, -1, 2, 1} - 6
	}

}
