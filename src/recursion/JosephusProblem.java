package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Find safe position
 */

public class JosephusProblem {
	static int ans = -1;
	
	//from geeks for geeks
	static int josephus(int n, int k) 
	{ 
	if (n == 1) 
	    return 1; 
	else
	    /* The position returned by josephus(n - 1, k)  
	    is adjusted because the recursive call  
	    josephus(n - 1, k) considers the original  
	    position k%n + 1 as position 1 */
	    return (josephus(n - 1, k) + k-1) % n + 1; 
	} 
	
	public static void solve(List<Integer> list, int k, int index) {
		if(list.size() == 1) {
			ans = list.get(0);
			return;
		}
		
		//smaller input
		index = (index + k) % list.size();
		list.remove(index);
		solve(list, k, index);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		int n = 14;
		int k = 2;
		for(int i=0;i<n;i++)
			list.add(i+1);
		
		solve(list, 7, k-1);
		System.out.println(ans);
	}

}
