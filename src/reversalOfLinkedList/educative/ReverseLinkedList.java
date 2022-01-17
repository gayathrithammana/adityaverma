package reversalOfLinkedList.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class ReverseLinkedList {

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		
		while(head != null) {
			next = head.next;	// temporarily store the next node
			head.next = prev;   // reverse the current node
			prev = head;		// before we move to the next node, point previous to the current node
			head = next;		// move on the next node
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);

		ListNode result = ReverseLinkedList.reverse(head);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;

		}

	}
}

class ListNode {
	int value = 0;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}
