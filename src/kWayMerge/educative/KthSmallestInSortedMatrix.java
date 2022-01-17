package kWayMerge.educative;

import java.util.PriorityQueue;

/**
 * Leetcode 378:Kth Smallest Element in a Sorted Matrix  
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
 * Time Complexity: O(min(K, N) + K * logN)
 * Space Complexity: O(N)
 */
public class KthSmallestInSortedMatrix {
	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node1> minHeap = new PriorityQueue<Node1>(
				(n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
		
		for (int i = 0; i < matrix.length && i < k; i++)
			minHeap.add(new Node1(i, 0));

		int count = 0;
		while (!minHeap.isEmpty()) {
			Node1 current = minHeap.poll();

			if (++count == k)
				return matrix[current.row][current.col];

			current.col++;
			
			// if the row of the top element has more elements, add the next element to the heap
			if (matrix[0].length > current.col)
				minHeap.add(current);
		}

		return 0;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };	//7
		int result = findKthSmallest(matrix, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}

class Node1 {
	int row;
	int col;

	Node1(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
