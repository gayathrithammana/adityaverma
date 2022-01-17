package kWayMerge.educative;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 632. Smallest Range Covering Elements from K Lists
 * 
 * Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
 * 
 * Create a class to track element index and index of array in which element is present
 * 
 * 1. add all first elements in each row minheap
 *    - and find max element so far of first elements in each row minheap
 * 2. rangeStart = 0 and rangeEnd = Math.max
 * 3. while min heap == lists.size
 *    - pop peek element from heap(currentElement)
 *    - max - currentElement < rangeStart - rangeEnd
 *    - update ranges [currentElment, max]
 *    - element index++
 *    - if peek element array length > element index 
 *    	- add element index to min heap
 *      - again cal max
 *    
 *
 * Time Complexity: O(N * logM)
 * Space Complexity: O(M)
 */
public class SmallestNumberRange {
	public static int[] findSmallestRange(List<Integer[]> lists) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				minHeap.offer(new Node(0, i));	//add first element in each list
				max = Math.max(max, lists.get(i)[0]);
			}
		}

		int rangeStart = 0;
		int rangeEnd = Integer.MAX_VALUE;
		
		while (minHeap.size() == lists.size()) {
			Node current = minHeap.poll();
			int currentElement = lists.get(current.arrayIndex)[current.elementIndex];
			if ((max - currentElement) < (rangeEnd - rangeStart)) {
				rangeStart = currentElement;
				rangeEnd = max;
			}
			current.elementIndex++;
			if (lists.get(current.arrayIndex).length > current.elementIndex) {
				minHeap.add(current);
				currentElement = lists.get(current.arrayIndex)[current.elementIndex];
				max = Math.max(max, currentElement);
			}
		}

		return new int[] { rangeStart, rangeEnd };
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 1, 5, 8 };
		Integer[] l2 = new Integer[] { 4, 12 };
		Integer[] l3 = new Integer[] { 7, 8, 10 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int[] result = findSmallestRange(lists);
		System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
		
		// Output: [4, 7]
	    // Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
	}
}
