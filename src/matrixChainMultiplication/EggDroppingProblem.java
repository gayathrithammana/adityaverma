package matrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 887. Super Egg Drop
 * TO-DO : leetcode timedout
 *
 */
public class EggDroppingProblem {
	static int t[][] = new int[100][10000];
	public static int solve(int e, int f) {
		if(f == 0 || f == 1)	//if no or first floor then current floor itself is the answer
			return f;
		if(e == 1)				//if only one egg is given in worst case current floor will be the answer
			return f;
		
		if(t[e][f] != -1)
			return t[e][f];
		
		int min = Integer.MAX_VALUE;
		
		for(int k = 1; k <= f; k++) {
			int low = 0;
			if(t[e-1][k-1] != -1)
				low = t[e-1][k-1];
			else
				low = solve(e-1, k-1);
			
			int high = 0;
			if(t[e][f-k] != -1)
				high = t[e][f-k];
			else
				high = solve(e, f-k);
			
			//temp is nothing but threshold floor that egg is breaking
			//max because we need to find min no.of attempts in worst case
			//we are starting from floor 1 and go up 
			int temp = 1 + Math.max(low, high);
			
			//here we need to find min attempts that is taking to find threshold floor
			min = Math.min(min, temp);
		}
		
		t[e][f] = min;
		return min;
	}
	
	public static int solveRecursive(int e, int f) {
		if(f == 0 || f == 1)	//if no or first floor then current floor itself is the answer
			return f;
		if(e == 1)				//if only one egg is given in worst case current floor will be the answer
			return f;
		
		int min = Integer.MAX_VALUE;
		
		for(int k = 1; k <= f; k++) {
			//max because we need to find min no.of attempts in worst case
			int temp = 1 + Math.max(solveRecursive(e-1, f-1), 
									solveRecursive(e, f-k));
			min = Math.min(min, temp);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			for(int j=0;j<10000;j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(solve(2, 6));
	}
	
	public int superEggDrop(int K, int N) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        return solve(K, N, map);
    }
    
    public int solve(int e, int f, Map<String, Integer> map){
        if(f == 0 || f == 1)
            return f;
        if(e == 1)
            return f;
        String key = e + ":" + f;
        if(map.containsKey(key))
            return map.get(key);
        
         int min = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            String key1 = (e-1) + ":" + (k-1);
            int low = 0;
            if(!map.containsKey(key1))
                low = solve(e-1, k-1, map);
            else
                low = map.get(key1);
            
            String key2 = (e) + ":" + (f-k);
            int high = 0;
            if(!map.containsKey(key2))
                high = solve(e, f-k, map);
            else
                high = map.get(key2);
            
            
            int temp = 1 + Math.max(low, high);
            min = Math.min(temp, min);
        }
        
        map.put(key, min);
        return min;
    }
}
