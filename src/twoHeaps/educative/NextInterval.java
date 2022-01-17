package twoHeaps.educative;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Leetcode 436. Find Right Interval
 * 
 * MaxStartHeap - to store based on start of interval MaxEndHeap - to store
 * based on end of interval
 * 
 * Time Complexity - O(NlogN) , N= total no.of intervals
 * 
 * Space Complexity O(N) - we are storing all intervals in heaps
 */

public class NextInterval {
	public static int[] findNextInterval(Interval[] intervals) {
		int n = intervals.length;

		PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n,
				(i1, i2) -> intervals[i2].start - intervals[i1].start);
		PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);

		for (int i = 0; i < n; i++) {
			maxStartHeap.offer(i);
			maxEndHeap.offer(i);
		}

		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			int topEnd = maxEndHeap.poll();
			result[topEnd] = -1;

			if (intervals[topEnd].end <= intervals[maxStartHeap.peek()].start) {

				int topStart = maxStartHeap.poll();
				// find the the interval that has the closest 'start'
				while (!maxStartHeap.isEmpty() && intervals[topEnd].end <= intervals[maxStartHeap.peek()].start) {
					topStart = maxStartHeap.poll();
				}

				result[topEnd] = topStart;
				maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
			}
		}

		return result;

	}

	public static int[] findNextInterval1(int[][] intervals) {
	        //from leetcode solutions
	       int[] result = new int[intervals.length];
	        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
	        
	        for (int i = 0; i < intervals.length; ++i) {
	            intervalMap.put(intervals[i][0], i);    
	        }
	        
	        for (int i = 0; i < intervals.length; ++i) {
	            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
	            result[i] = (entry != null) ? entry.getValue() : -1;
	        }
	        
	        return result;
	    

	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
		int[] result = findNextInterval(intervals);
		System.out.print("Next interval indices are: ");	//1, 2, -1
		for (int index : result)
			System.out.print(index + " ");
		System.out.println();

		intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
		result = findNextInterval(intervals);
		System.out.print("Next interval indices are: ");	//2, -1, -1
		for (int index : result)
			System.out.print(index + " ");
		
		
//		int intervals[][] = new int[][] { {3,4},{2,3},{1,2} };
//		int[] result = findNextInterval1(intervals);
//		System.out.println("Next interval indices are: ");	//-1, 0, 1
//		for (int index : result)
//			System.out.print(index + " ");
		System.out.println();
		int intervals1[][] = new int[][] { {1,4},{2,3},{3,4} };
		result = findNextInterval1(intervals1);
		System.out.print("Next interval indices are: ");	//-1, 2, -1
		for (int index : result)
			System.out.print(index + " ");
		
		System.out.println();
		int intervals2[][] = new int[][] { {1,2},{2,3},{0,1},{3,4} };
		result = findNextInterval1(intervals2);
		System.out.print("Next interval indices are: ");	//1,3,0,-1
		for (int index : result)
			System.out.print(index + " ");
	}
}

class Interval {
	int start = 0;
	int end = 0;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Pair {
	int start;
	int index;

	Pair(int start, int index) {
		this.start = start;
		this.index = index;
	}
}
