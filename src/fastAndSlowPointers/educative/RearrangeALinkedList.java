package fastAndSlowPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */

public class RearrangeALinkedList {

	public static void rearrange(ListNode head) {
		// 1.find middle node
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 2.reverse second half
		ListNode secondHalfHead = reverse(slow);
		
		ListNode firstHalfHead = head;
		while (firstHalfHead != null && secondHalfHead != null) {
			ListNode temp = firstHalfHead.next;
			firstHalfHead.next = secondHalfHead;
			firstHalfHead = temp;

			temp = secondHalfHead.next;
			secondHalfHead.next = firstHalfHead;
			
			secondHalfHead = temp;
		}

		if (firstHalfHead != null)
			firstHalfHead.next = null;

	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = null;

		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		rearrange(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		
		/**
		 * 2 4 6 8 10 12
		 * 2 4 6 12 10 8
		 * 2 12 4 10 6 8
		 */
	}

}
