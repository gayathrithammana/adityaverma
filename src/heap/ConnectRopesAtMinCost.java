package heap;

/**
 * Connect ropes to Minimize the cost\
 * use min heap 
 * sum top 2 elements add the result back to heap
 */

import java.util.PriorityQueue;

public class ConnectRopesAtMinCost {

	private static int kthLargest(int[] arr) {
		//by default PQ is minHeap
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i : arr) {
			minHeap.add(i);
		}
		
		int cost = 0;
		while(minHeap.size() >= 2) {
			int first = minHeap.poll();
			int second = minHeap.poll();
			
			cost += first + second;
			
			minHeap.add(first + second);
		}
		
		return cost;
	}

	public static void main(String[] args) {
		System.out.println(kthLargest(new int[] { 2, 3, 1, 4, 5 }));	//33
	}
}
