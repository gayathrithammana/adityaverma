package fastAndSlowPointers.educative;

public class FindStartOfLinkedListCycle {

	public static ListNode startPoint(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}
		
		if(fast == null)
			return new ListNode(-1);

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		    head.next = new ListNode(2);
		    head.next.next = new ListNode(3);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(5);
		    head.next.next.next.next.next = new ListNode(6);

		    head.next.next.next.next.next.next = head.next.next;
		    System.out.println("LinkedList cycle start: " + startPoint(head).value);

		    head.next.next.next.next.next.next = head.next.next.next;
		    System.out.println("LinkedList cycle start: " + startPoint(head).value);

		    head.next.next.next.next.next.next = head;
		    System.out.println("LinkedList cycle start: " + startPoint(head).value);
	}

}
