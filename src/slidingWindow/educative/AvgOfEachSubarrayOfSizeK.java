package slidingWindow.educative;

/***
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class AvgOfEachSubarrayOfSizeK {
	
	private static double[] avgWindowK(int[] arr, int k) {
		int len = arr.length;
		double[] avg = new double[len - k + 1];
		
		int i=0;
		int j=0;
		
		double sum = 0;
		while(j < len) {
			sum += arr[j];
			
			if(j - i + 1 < k)
				j++;
			else if(j - i + 1 == k) {
				avg[i] = sum / 5;
				
				sum -= arr[i];
				
				i++;
				j++;
			}
		}
		
		return avg;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
		double[] output = avgWindowK(input, 5);
		for(double avg : output)
			System.out.println(avg);
		
		
	}

}
