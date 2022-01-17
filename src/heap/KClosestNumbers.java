package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * sort the differences of a given number 
 * use max heap to store min differences
 */

public class KClosestNumbers {

	private static List<Integer> kClosest(int[] arr, int k, int x) {
		int len = arr.length;
		List<Integer> result = new ArrayList<Integer>();

		// use max heap
		//Pair class is defined below which implemented Comparator compare
		//Pair = {diff, current element}
		Queue<MaxHeapPair> maxHeap = new PriorityQueue<MaxHeapPair>(new MaxHeapPair());

		for (int i = 0; i < len; i++) {  
			maxHeap.add(new MaxHeapPair(Math.abs(arr[i] - x), arr[i]));
			// Keep only k elements in queue
			if (maxHeap.size() > k) {
				maxHeap.poll(); // remove max diff elem
			}
		}
		
		//add remaining min diff elem left in heap
		while(!maxHeap.isEmpty()) {
			MaxHeapPair pair = maxHeap.poll();
			result.add(pair.value);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = kClosest(new int[] { 5, 6, 7, 8, 9 }, 3, 7);	//6, 7, 8
		for (int i : result) {
			System.out.println(i);
		}
	}

}

class MaxHeapPair implements Comparator<MaxHeapPair> {
	int key;	//diff
	int value;	//element

	MaxHeapPair() {

	}

	MaxHeapPair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int compare(MaxHeapPair p1, MaxHeapPair p2) {
		return p2.key - p1.key;		//max heap
	}

	public String toString() {
		return String.valueOf(key);
	}

}
