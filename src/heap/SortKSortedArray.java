package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * use min heap
 */
public class SortKSortedArray {
	
	private static List<Integer> kSorted(int[] arr, int k) {
		int len = arr.length;
		List<Integer> result = new ArrayList<Integer>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for (int i=0;i<len;i++) {
			minHeap.add(arr[i]);
			//Keep only k elements in queue
			if (minHeap.size() > k) {
				result.add(minHeap.poll());	//min element
			}
		}
		
		int size = minHeap.size();
		for(int i=0;i<size;i++) {
			result.add(minHeap.poll());
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = kSorted(new int[] { 6, 5, 3, 2, 8, 10, 9 }, 3);
		for(int i:result) {
			System.out.println(i);
		}
	}

}
