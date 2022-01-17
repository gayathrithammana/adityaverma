package mergeIntervals.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(N+M)
 * Space Complexity O(1) - ignoring the space needed for the result list
 */

public class IntervalsIntersection {

	public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
		List<Interval> result = new ArrayList<Interval>();
		// TODO: Write your code here
		int i = 0;
		int j = 0;
		
		while(i < arr1.length && j < arr2.length) {
			Interval interval1 = arr1[i];
			Interval interval2 = arr2[j];
			
			if((interval2.start >= interval1.start && interval2.start <= interval1.end) ||
			   (interval1.start >= interval2.start && interval1.start <= interval2.end)) {
				
				int start = Math.max(interval1.start, interval2.start);
				int end = Math.min(interval1.end, interval2.end);
				
				result.add(new Interval(start, end));
			}
			
			if (interval1.end < interval2.end)
				i++;
			else
				j++;
			
		}
		
		
		return result.toArray(new Interval[result.size()]);
	}

	public static void main(String[] args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		Interval[] result = merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
		input2 = new Interval[] { new Interval(5, 10) };
		result = merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
	}

}
