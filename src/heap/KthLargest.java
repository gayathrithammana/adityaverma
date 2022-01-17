package heap;

import java.util.PriorityQueue;

public class KthLargest {
	private static int kthLargest(int[] arr, int k) {
		//by default it is max PQ  - minHeap
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for (int i : arr) {
			minHeap.add(i);
			//Keep only k elements in queue
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		System.out.println(kthLargest(new int[] { 2, 8, 3, 5, 10, 9, 12, 11 }, 5));
		// sorted array 12, 11, 10, 9, 8, 5, 3, 2
	}
}
