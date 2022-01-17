package twoHeaps.educative;

import java.util.PriorityQueue;

/**
 * Leetcode 502. IPO
 * 
 * MinHeap to store all the capitals that are eligible(<= initialCapital)
 * - as we need to pop max capitals which are not required we will need minheap
 * 
 * MaxHeap to store most profitable capitals. 
 * - as we need to pop minimum profits we will need max heap 
 * 
 * Time Complexity - O(NlogN+KlogN) , N= total projects, K=no.of projects we are selecting
 * as the most all the projects will be pushed to both heaps
 * 
 * Space Complexity O(N) - we are storing all projects in heaps
 *
 */

public class MaximizeCapital {
	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		int n = profits.length;

		PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<Integer>(n, (i1, i2) -> capital[i1] - capital[i2]);
		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<Integer>(n, (i1, i2) -> profits[i2] - profits[i1]);

		for (int i = 0; i < n; i++)
			minCapitalHeap.offer(i);

		for (int j = 0; j < numberOfProjects; j++) {
			while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= initialCapital)
				maxProfitHeap.add(minCapitalHeap.poll());

			if (maxProfitHeap.isEmpty())
				break;

			initialCapital += profits[maxProfitHeap.poll()];
		}

		return initialCapital;
	}

	public static void main(String[] args) {
		int result = findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);	//6
		System.out.println("Maximum capital: " + result);
		result = findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);	//8
		System.out.println("Maximum capital: " + result);
	}
}
