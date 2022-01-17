package mergeIntervals.educative;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * same as minimum meeting rooms
 *
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
public class MaximumCPULoad {

	// from sloutions
	public static int findMaxCPULoad(List<Job> jobs) {
		if (jobs == null || jobs.isEmpty())
			return 0;

		if (jobs.size() == 1)
			return jobs.get(0).cpuLoad;

		// 1.sort by start time
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
		
		//3. order min heap by end time so when we pop it should remove first finished job first
		PriorityQueue<Job> minHeap = new PriorityQueue<Job>(jobs.size(), 
															(a,b) -> Integer.compare(a.end, b.end));
		
		int maxLoad = 0;
		int currentLoad = 0;
		
		for(Job job:jobs) {
			
			//2. create a min heap which stores only overlapping jobs at any time. and then insert the meeting
			//pop that are not overlapped.i.e, remove load of not overlapped from overall load
			//!(job.start < minHeap.peek.end) ==> (job.start >= minHeap.peek.end)
			while(minHeap.size() > 0 && job.start > minHeap.peek().end)
				currentLoad -= minHeap.poll().cpuLoad;
			
			minHeap.offer(job);
			currentLoad += job.cpuLoad;
			
			maxLoad = Math.max(currentLoad, maxLoad);
			
		}
		
		return maxLoad;
	}

	// my sloution
	public static int findMaxCPULoad1(List<Job> jobs) {

		if (jobs == null || jobs.isEmpty())
			return 0;

		if (jobs.size() == 1)
			return jobs.get(0).cpuLoad;

		// 1.sort by start time
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

		int start = jobs.get(0).start;
		int end = jobs.get(0).end;
		int cPULoad = jobs.get(0).cpuLoad;
		int maxCPULoad = cPULoad;

		for (int i = 1; i < jobs.size(); i++) {
			int currentStart = jobs.get(i).start;
			int currentEnd = jobs.get(i).end;
			int currrentCPULoad = jobs.get(i).cpuLoad;

			// if overlapping
			if (currentStart < end) {
				start = Math.min(start, currentStart);
				end = Math.max(end, currentEnd);
				cPULoad += currrentCPULoad;

				maxCPULoad = Math.max(maxCPULoad, cPULoad);
			} else
				maxCPULoad = Math.max(maxCPULoad, currrentCPULoad);

		}

		return maxCPULoad;
	}

	public static void main(String[] args) {
		List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
		System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
		System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
		System.out.println("Maximum CPU load at any time: " + findMaxCPULoad(input));
	}
}

class Job {
	int start;
	int end;
	int cpuLoad;

	public Job(int start, int end, int cpuLoad) {
		this.start = start;
		this.end = end;
		this.cpuLoad = cpuLoad;
	}
};
