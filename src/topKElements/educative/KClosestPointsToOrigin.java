package topKElements.educative;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 973. K Closest Points to Origin
 * Find K closet points to origin
 * 
 * We need points which euclidean distance is smaller
 * 
 * Use maxHeap which ensures to keep smaller elements in heap(as we will be storing only K elements in heap)
 * 
 * 1. add first K elements to max heap
 * 2. for each element in other n-k elements(k -> nums.length)
 *    - check if peek element E.D in heap is > nums[i]
 *    - if it is pop element from heap and insert nums[i]
 *    
 * Time Complexity: O(N * logK)
 * Space Complexity: O(K)
 */

public class KClosestPointsToOrigin {
	public static List<Point> findClosestPoints(Point[] points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
		
		for(int i=0;i<k;i++)
			maxHeap.add(points[i]);
		
		for(int i=k;i<points.length;i++) {
			if(points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(points[i]);
			}
		}
		return new ArrayList<>(maxHeap);
	}

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };	//[1 , 3] [2 , -1] 
		List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
		System.out.print("Here are the k points closest the origin: ");
		for (Point p : result)
			System.out.print("[" + p.x + " , " + p.y + "] ");
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distFromOrigin() {
		// ignoring sqrt
		return (x * x) + (y * y);
	}
}
