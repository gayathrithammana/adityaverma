package kWayMerge.educative;

import java.util.PriorityQueue;

/**
 * Leetcode 
 * 
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
 * 
 * 1. add all roots to min heap
 * 2. declare 2 variables, head and tail
 * 3. while min heap is not empty
 *    - if head is null head = tail = peek element
 *    - else tail.next = peek element
 *           tail = tail.next
 *    - add peek element.next to min heap
 *
 * Time Complexity: O(N * logK) - N toal no.of elements in all K input arrays
 * Space Complexity: O(K)
 */

public class MergeKSortedLists {
	public static ListNode merge(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.value - n2.value);
		
		for(ListNode root : lists) {
			if(root != null)
				minHeap.offer(root);
		}
		
		ListNode head = null;
		ListNode tail = null;
		
		while(!minHeap.isEmpty()) {
			ListNode current = minHeap.poll();
			
			if(head == null)
				head = tail = current;
			else {
				tail.next = current;
				tail = tail.next;
			}
			
			if(current.next != null)
				minHeap.offer(current.next);
		}
		
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);

		ListNode result = merge(new ListNode[] { l1, l2, l3 });
		System.out.print("Here are the elements form the merged list: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}
