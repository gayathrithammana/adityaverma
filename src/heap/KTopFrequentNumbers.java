package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KTopFrequentNumbers {

	private static List<Integer> kFrequent(int[] arr, int k) {
		List<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 0);
		}

		// use min heap
		// Pair class is defined below which implemented Comparator compare
		// Pair = {count, key}
		Queue<MinHeapPair> minHeap = new PriorityQueue<MinHeapPair>(new MinHeapPair());

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(new MinHeapPair(entry.getValue(), entry.getKey()));
			// Keep only k elements in queue
			if (minHeap.size() > k) {
				minHeap.poll(); // remove min freq elem
			}
		}
		
		//add remaining max freq elem left in heap
		while (!minHeap.isEmpty()){
			MinHeapPair pair = minHeap.poll();
			result.add(pair.value);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = kFrequent(new int[] { 1, 1, 1, 3, 2, 2, 4 }, 2);	//find top 2 = [1, 2]
		/**
		 * 1: 3
		 * 2: 2
		 * 3: 1
		 * 4: 1
		 * 
		 */
		for (int i : result) {
			System.out.println(i);
		}
	}

}

class MinHeapPair implements Comparator<MinHeapPair> {
	int key; // diff
	int value; // element

	MinHeapPair() {

	}

	MinHeapPair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int compare(MinHeapPair p1, MinHeapPair p2) {
		return p1.key - p2.key;		//min heap

	}

	public String toString() {
		return String.valueOf(key);
	}

}
