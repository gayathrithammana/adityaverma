package mergeIntervals.educative;

import java.util.Arrays;

/**
 * Time Complexity O(N * logN)
 * 
 * where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N),
 *  in the beginning though, since we need to sort the intervals, our algorithm will take O(N * logN).
 *  
 * Space Complexity O(N)
 * 
 * For Java, Arrays.sort() uses Timsort, which needs O(N) space.
 */

public class ConflictingAppointments {

	public static boolean canAttendAllAppointments(Interval[] intervals) {
		
		//1.start by start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		
		for(int i = 1; i < intervals.length; i++) {
			Interval interval1 = intervals[i - 1];
			Interval interval2 = intervals[i];
			
			 // please note the comparison above, it is "<" and not "<="
	        // while merging we needed "<=" comparison, as we will be merging the two
	        // intervals having condition "intervals[i].start == intervals[i - 1].end" but
	        // such intervals don't represent conflicting appointments as one starts right
	        // after the other
			if(interval2.start < interval1.end) {	//overlap
				return false;
			}
			
		}
			
		
		return true;
	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);	//false

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);	//true

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);	//false
	}

}
