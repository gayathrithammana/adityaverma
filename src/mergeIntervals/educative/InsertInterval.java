package mergeIntervals.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity O(N)
 * Space Complexity O(N)
 */

public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.isEmpty())
			return Arrays.asList(newInterval);
		
		List<Interval> mergedIntervals = new ArrayList<>();

		int i = 0;
		int len = intervals.size();
		// 1.skip intervals that do not overlap
		// i.e.m aEnd < bStart
		while (i < len && intervals.get(i).end < newInterval.start) {
			mergedIntervals.add(intervals.get(i));
			i++;
		}

		// 2. if they overlap update new interval
		while(i < len && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			
			i++;
		}

		// 3.add updated new interval to result
		mergedIntervals.add(newInterval);

		// 4.add remainig intervals
		while(i < len) {
			mergedIntervals.add(intervals.get(i));
			i++;
		}

		return mergedIntervals;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
