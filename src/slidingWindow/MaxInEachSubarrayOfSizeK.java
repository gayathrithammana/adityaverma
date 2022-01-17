package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxInEachSubarrayOfSizeK {
	public static List<Integer> max(int[] arr, int k) {
		int i = 0;
		int j = 0;
		
		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> ans = new ArrayList<Integer>();
		
		while (j < arr.length) {
			
			//calculations
			//remove elements less than arr[j] which are of no use 
			//after this step only one element will be present which is max
			while(!deque.isEmpty() && deque.peekLast() < arr[j]) {
				deque.removeLast();
			}
			
			//add next elements to queue which will be useful elements in next sliding
			deque.addLast(arr[j]);
			
			if (j - i + 1 < k) 
				j++;
			else if (j - i + 1 == k) {
				//add element to ans
				ans.add(deque.getFirst());
				
				//before sliding revert calculations of i
				//does i present at first 
				if(deque.getFirst() == arr[i])
					deque.removeFirst();
					
				//slide window
				i++;
				j++;
			}
		}
		
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(max(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
	}
}
