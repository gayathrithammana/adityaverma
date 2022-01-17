package fastAndSlowPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class MiddleOfLinkedList {
	
	public static ListNode find(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    System.out.println("Middle Node: " + find(head).value);

	    head.next.next.next.next.next = new ListNode(6);
	    System.out.println("Middle Node: " + find(head).value);

	    head.next.next.next.next.next.next = new ListNode(7);
	    System.out.println("Middle Node: " + find(head).value);
	}

}
