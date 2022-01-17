package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

	private static int[][] kClosest(int[][] arr, int k) {
		int[][] result = new int[k][2];

		// use max heap
		//Pair class is defined below which implemented Comparator compare
		//Pair = {x^2 + y^2, x, y}
		Queue<MaxHeapTriplet> maxHeap = new PriorityQueue<MaxHeapTriplet>(new MaxHeapTriplet());

		for (int i = 0; i < arr.length; i++) { 
			int x = arr[i][0];
			int y = arr[i][1];
			
			maxHeap.add(new MaxHeapTriplet(x*x + y*y, x, y));
			
			if (maxHeap.size() > k) {
				maxHeap.poll(); // remove max distance elem
			}
		}
		
		int count = k;
		//add remaining min diff elem left in heap
		while(!maxHeap.isEmpty()) {
			MaxHeapTriplet pair = maxHeap.poll();
			int x = pair.x;
			int y = pair.y;
			
			result[count-1][0] = x;
			result[count-1][1] = y;
			
			count--;
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] input = new int[4][2];
		input[0] = new int[] {1, 3};
		input[1] = new int[] {-2, 2};
		input[2] = new int[] {5, 8};
		input[3] = new int[] {0, 1};
		
		int[][] result = kClosest(input, 2);	//
		for (int i[] : result) {
			System.out.println(i[0] + " "  +i[1]);
		}
	}

}

class MaxHeapTriplet implements Comparator<MaxHeapTriplet> {
	int key;	//x^2 + y^2
	int x;	
	int y;

	MaxHeapTriplet() {

	}

	MaxHeapTriplet(int key, int x, int y) {
		this.key = key;
		this.x = x;
		this.y = y;
	}

	public int compare(MaxHeapTriplet p1, MaxHeapTriplet p2) {
		return p2.key - p1.key;		//max heap
	}

	public String toString() {
		return String.valueOf(key);
	}

}
