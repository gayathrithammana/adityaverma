package mergeIntervals.educative;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Time Complexity O(N * logN)
 * 
 * where ‘N’ is the total number of meetings. This is due to the sorting that we did in the beginning.
 * Also, while iterating the meetings we might need to poll/offer meeting to the priority queue. 
 * Each of these operations can take O(logN). Overall our algorithm will take O(NlogN).
 *  
 * Space Complexity O(N).
 * 
 *  O(N) for sorting. Worst case we insert all meetings to minHeap which is also O(N). Overall, O(N)
 */

public class MinimumMeetingsRooms {
	
	/**
	 * 1. sort list by start time
	 * 2. create a min heap which stores only overlapping meetings at any time. and then insert the meeting
	 * 3. order min heap by end time so when we pop it should remove first finished meeting first
	 * 4. cal max heap size in every iteration 
	 */
	
	public static int findMinimumMeetingRooms(List<Meeting> meetings) {
		if(meetings == null || meetings.size() == 0)
			return 0;
		if(meetings.size() == 1)
			return 1;
		
		//1.sort list by start time
		Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));
		
		//3. order min heap by end time so when we pop it should remove first finished meeting first
		PriorityQueue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(), 
																	(a,b) -> Integer.compare(a.end, b.end));
		
		int max = 0;
		
		for(Meeting oneMeeting : meetings) {
			
			//2. create a min heap which stores only overlapping meetings at any time. and then insert the meeting
			//pop that are not overlapped
			//!(oneMeeting.start < minHeap.peek.end) ==> (oneMeeting.start >= minHeap.peek.end)
			while(minHeap.size() > 0 && oneMeeting.start >= minHeap.peek().end)
				minHeap.poll();
			
			minHeap.offer(oneMeeting);
			
			//4. cal max heap size in every iteration 
			max = Math.max(max, minHeap.size());
		}
		
		return max;
	}

	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		int result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 5));
				add(new Meeting(7, 9));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(6, 7));
				add(new Meeting(2, 4));
				add(new Meeting(8, 12));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 3));
				add(new Meeting(3, 6));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);
	}

}

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
};
