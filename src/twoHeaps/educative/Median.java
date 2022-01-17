package twoHeaps.educative;

import java.util.PriorityQueue;

/** Leetcode - 295. Find Median from Data Stream
 * 
 * Time Complexity - insert - O(logN) due to the insertion in the heap
 * 				   - medain - O(1)
 * Space Complexity O(N) - we are storing all numbers
 */

public class Median {
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;
	
	public Median() {
		//minHeap is used to maintain largest elements and pop small elements
		minHeap = new PriorityQueue<Integer>();	//default
		maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
	}
	
	public void insertNum(int num) {
		//arbitory decision add to maxHeap first
		if(maxHeap.isEmpty() || num <= maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);
		
		if(maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if(maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());
	}

	public double findMedian() {
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		Median medianOfAStream = new Median();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());	//2.0
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());	//3.0
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());	//3.5
	}
}
