package topKElements.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode problem: 621. Task Scheduler
 * 
 * Given a list of tasks that need to be run, in any order.
 * Each task will take one CPU interval to execute but once a task has finished, 
 * it has a cooling period during which it can’t be run again. 
 * If the cooling period for all tasks is ‘K’ intervals, 
 * find the minimum number of CPU intervals that the server needs to finish all tasks.
 * 
 * Use MaxHeap 
 * 1. create freq map 
 * 2. add all entries to maxheap 
 * 3. while maxheap is not empty 
 * 	 - create a waitlist
 *   - for n=k+1 times
		- pop top entry and add its key to result(increase count) 
		- if freq > 1 reduce the freq and add to waitlist 
 * 4. add all waitlist back to maxheap
 * 5. if maxHeap is not empty add remaining n slots to result
 * 6. repeat while
 * 7. return count
 * 
 * Time Complexity: O(NlogN) 
 * Space Complexity: O(N)
 */

public class SchedulingTasks {
	public static int scheduleTasks(char[] tasks, int k) {
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (int i = 0; i < tasks.length; i++) {
			char currentChar = tasks[i];
			freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		maxHeap.addAll(freqMap.entrySet());

		int count = 0;
		while (!maxHeap.isEmpty()) {
			List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
			
			int n = k+1;
			
			// try to execute as many as 'k+1' tasks from the max-heap
			for(; n > 0 && !maxHeap.isEmpty(); n--) {
				Map.Entry<Character, Integer> current = maxHeap.poll();
				count++;	// append to resultant string
				if(current.getValue() > 1) {
					current.setValue(current.getValue() - 1);
					waitList.add(current);
				}
			}
			
			maxHeap.addAll(waitList);	// put all the waiting list back on the heap
			
			if(!maxHeap.isEmpty())		//add n idles to result
				count += n;
				
		}
		return count;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };	//7 -> a -> c -> b -> a -> c -> idle -> a
		System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 2));

		tasks = new char[] { 'a', 'b', 'a' };	//5 -> a -> b -> idle -> idle -> a
		System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 3));
	}
}
