package topKElements.educative;

import java.util.PriorityQueue;

/**
 * Leetcode 1167: Minimum Cost to Connect Sticks
 * 
 * We need to connect these ropes into one big rope with minimum cost.
 * 
 * Use minHeap while pop you can get minimum ropes and find cost
 * 
 * 1. add all ropes to minHeap
 * 2. pop 2 ropes which are minimum in length
 *    - find their sum and cal cost
 *    - add it back to minheap
 *    
 * Time Complexity: O(N * logN)
 * Space Complexity: O(K)
 */


public class ConnectingRopes {
	public static int minimumCostToConnectRopes(int[] ropeLengths) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int rope:ropeLengths)
			minHeap.offer(rope);
		
		int cost = 0;
		while(minHeap.size() > 1) {
			int rope1 = minHeap.poll();
			int rope2 = minHeap.poll();
			
			int newRope = rope1 + rope2;
			cost += newRope;
			minHeap.offer(newRope);
		}
		
		return cost;
	}

	public static void main(String[] args) {
		int result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });	//33
		System.out.println("Minimum cost to connect ropes: " + result);
		result = minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });	//36
		System.out.println("Minimum cost to connect ropes: " + result);
		result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });	//42
		System.out.println("Minimum cost to connect ropes: " + result);
	}
}
