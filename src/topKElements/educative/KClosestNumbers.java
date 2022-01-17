package topKElements.educative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 658. Find K Closest Elements
 * 
 * Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
 * Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 * 
 * 1. Find closest number to X using binary search
 *    - if element found at mid return mid
 *    - else until start <= end continue and return start - 1
 * 2. l = start, r= start + 1;
 * 3. if l >= 0 && r < length
 *    - find diff at l, r indexes and find smallest diff
 *    - if value at l is small add to beginning of result
 *    - else if value at r is small to add to end of result
 * 3. else if l >= 0
 *    - add value at l to beginning of result
 * 4. else if r < length
 *    - add value at r to end of result
 *    
 *    
 * Time Complexity: - O(logN + K)
 *  				- O(logN) for binary search
 *                  - to find K closest O(K)
 * Space Complexity: O(1) 
 */
public class KClosestNumbers {
	
	//using 2-pointers and Binary search
	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
		List<Integer> result = new LinkedList<Integer>();
		int l = binarySearch(arr, X);
		int r = l + 1;
		
		for(int i=0;i<K;i++) {
			if(l >= 0 && r < arr.length) {
				int diff1 = Math.abs(X - arr[l]);
				int diff2 = Math.abs(X - arr[r]);
				
				if(diff1 <= diff2)
					result.add(0, arr[l--]); 	//add at beginning
				else
					result.add(arr[r++]);
			} else if(l >= 0)
				result.add(0, arr[l--]);
			else if(r < arr.length)
				result.add(arr[r++]);
		}
		
		return result;
	}
	
	public static int binarySearch(int[] arr, int target) {
		int start = 0;
	    int end = arr.length - 1;
	    
	    while (start <= end) {
	      int mid = start + (end - start) / 2;
	      
	      if (arr[mid] == target)
	        return mid;
	      
	      if (arr[mid] < target)
	        start = mid + 1;
	      else
	        end = mid - 1;
	    }
	    
	    if (start > 0)
	      return start - 1;

	    return start;	//if start = 0
	}
	
	
	//using heaps
	public static List<Integer> findClosestElements1(int[] arr, int K, Integer X) {
		int index = binarySearch(arr, X);
	    int start = index - K;
	    int end = index + K;
	    
	    start = Math.max(start, 0); // 'low' should not be less than zero
	    end = Math.min(end, arr.length - 1); // 'high' should not be greater the size of the array

	    PriorityQueue<Entry> minHeap = new PriorityQueue<>((e1, e2) -> e1.key - e2.key);
	    // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
	    for (int i = start; i <= end; i++)
	      minHeap.add(new Entry(Math.abs(arr[i] - X), i));

	    // we need the top 'K' elements having smallest difference from 'X'
	    List<Integer> result = new ArrayList<>();
	    for (int i = 0; i < K; i++)
	      result.add(arr[minHeap.poll().value]);

	    Collections.sort(result);
	    
	    return result;
	}
	
	public static void main(String[] args) {
		List<Integer> result = findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);	//[6, 7, 8]
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);	//[4, 5, 6]
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);	//[5, 6, 9]
		System.out.println("'K' closest numbers to 'X' are: " + result);
	}
}

class Entry {
	int key;
	int value;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
