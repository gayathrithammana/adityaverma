package mergeIntervals.educative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Time Complexity O(N * logN)
 * 
 * where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N),
 *  in the beginning though, since we need to sort the intervals, our algorithm will take O(N * logN).
 * Space Complexity O(N)
 * 
 * The space complexity of the above algorithm will be O(N) as we need to return a list containing all the merged intervals. 
 * We will also need O(N)space for sorting. Depending on its version, Collection.sort() either uses Merge sort or Timsort, 
 * and both these algorithms need O(N) space. Overall, our algorithm has a space complexity of O(N).
 */

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		
		if(intervals.size() < 2)
			return intervals;
		
		Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
		
		List<Interval> result = new ArrayList<Interval>();
		
		Iterator<Interval> iterator = intervals.iterator();
		Interval a = iterator.next();
		int aStart = a.start;
		int aEnd = a.end;
		
		while(iterator.hasNext()) {
			Interval b = iterator.next();
			int bStart = b.start;
			int bEnd = b.end;
			
			if(bStart <= aEnd) {
				aEnd = Math.max(aEnd, bEnd);
			} else {
				result.add(new Interval(aStart, aEnd));
				aStart = bStart;
				aEnd = bEnd;
			}
		}
				
		result.add(new Interval(aStart, aEnd));
		return result;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		System.out.print("Merged intervals: ");
		for (Interval interval : merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
};
