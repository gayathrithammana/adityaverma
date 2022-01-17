package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {
	private static List<Integer> frequencySort(int[] arr) {
		List<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 0);
		}

		// use max heap - more freq elements will be at top
		// MaxHeapPair class is defined in "KClosestNumbers" class
		// Pair = {freq, elem}
		Queue<MaxHeapPair> maxHeap = new PriorityQueue<MaxHeapPair>(new MaxHeapPair());

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(new MaxHeapPair(entry.getValue(), entry.getKey()));
		}

		while (!maxHeap.isEmpty()){
			MaxHeapPair pair = maxHeap.poll();
			int freq = pair.key;
			int elem = pair.value;
			
			for(int i=0;i<=freq;i++) {
				result.add(elem);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = frequencySort(new int[] { 1, 1, 1, 3, 2, 2, 4 });
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
