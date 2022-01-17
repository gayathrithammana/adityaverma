package kWayMerge.educative;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 
 * 
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
 * 
 * Create a class to track element index and index of array in which element is present
 * 
 * 1. add all first elements of each list to  minheap
 * 2. count = 0
 * 3. while min heap is not empty
 *    - ++count == k return peek element
 *    - increase peek element elementIndex
 *    - if peek element array length > element index add element index to min heap
 *
 * Time Complexity: O(K * logM)
 * Space Complexity: O(M)
 */

public class KthSmallestInMSortedLists {
	public static int findKthSmallest(List<Integer[]> lists, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> 
										lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
		for(int i=0;i<lists.size();i++)
			if(lists.get(i) != null)
				minHeap.offer(new Node(0, i));
		
		int count = 0;
		while(!minHeap.isEmpty()) {
			Node current = minHeap.poll();
			
			if(++count == k)
				return lists.get(current.arrayIndex)[current.elementIndex];
			
			current.elementIndex++;
			if(lists.get(current.arrayIndex).length > current.elementIndex)
				minHeap.add(current);
		}
		
		return 0;
		
	  }

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();	//4
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}

class Node {
	int elementIndex;
	int arrayIndex;

	Node(int elementIndex, int arrayIndex) {
		this.elementIndex = elementIndex;
		this.arrayIndex = arrayIndex;
	}
}
