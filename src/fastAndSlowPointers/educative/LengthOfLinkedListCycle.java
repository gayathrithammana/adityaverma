package fastAndSlowPointers.educative;

public class LengthOfLinkedListCycle {

	public static int hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return calCycleLength(slow);
		}
		return 0;
	}

	private static int calCycleLength(ListNode slow) {
		ListNode temp = slow;
		int len = 0;
		
		do{
			temp = temp.next;
			len++;
		} while(temp != slow);
		
		return len;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println(hasCycle(head));

		head.next.next.next.next.next.next = head.next.next;
		System.out.println(hasCycle(head));

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println(hasCycle(head));
	}

}

