package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {

	static int kthSmallest(int[] arr, int k) {
		//use max heap
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for(int i:arr) {
			maxHeap.add(i);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[] {7, 10, 4, 3, 20, 15}, 3));
		//use minimum PQ, to store 4 min elements
	}

}
