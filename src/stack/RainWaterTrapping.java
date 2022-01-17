package stack;

/**
 * https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
 *  sum of all(min(maxL , maxR) - arr[i])
 */

public class RainWaterTrapping {
	
	private static int solve(int[] arr) {
		int len = arr.length;
		int maxL[] = new int[len];
		maxL[0] = arr[0];
		for(int i=1;i<len;i++) {
			maxL[i] = Math.max(maxL[i-1], arr[i]);
		}
		
		int maxR[] = new int[len];
		maxR[len - 1] = arr[len -1];
		for(int i=len-2;i>=0;i--) {
			maxR[i] = Math.max(maxR[i+1], arr[i]);
		}
		
		int waterArea = 0;
		for(int i=0;i<len;i++) {
			waterArea = waterArea + (Math.min(maxL[i], maxR[i]) - arr[i]);
		}
		
		
		return waterArea;
	}

	public static void main(String[] args) {
		int input[] = new int[] {3, 0, 0, 2, 0, 4};
		System.out.println(solve(input));
	}

}
