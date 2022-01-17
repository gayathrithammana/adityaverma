package reversalOfLinkedList.educative;

/**
 * Time Complexity O(N) 
 * Space Complexity O(1)
 */
public class ReverseAlternateKElements {
	public static ListNode reverse(ListNode head, int k) {

		if (k < 2 || head == null)
			return head;

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			
			ListNode beforeP = prev;	// p - 1 the element
			ListNode atP = current;		//p th element
			ListNode next = null;
			
			for (int i = 0; current != null && i < k; i++) {
				next = current.next; // temporarily store the next node
				current.next = prev; // reverse the current node
				prev = current; // before we move to the next node, point previous to the current node
				current = next; // move on the next node
			}

			if (beforeP != null)
				beforeP.next = prev;
			else
				head = prev; // if p == 1 we are changing the first node of ll ex: ([3,5], 1, 2)

			atP.next = current;
			
			//skip k elements
			for(int i = 0; current != null && i < k; i++) {
				prev = current;
				current = current.next;
			}
			
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverse(head, 2);
		System.out.print("Nodes of the reversed LinkedList are: "); // 2 1 3 4 6 5 7 8 
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;

		}
		System.out.println();
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		result = reverse(head, 2);
		System.out.print("Nodes of the reversed LinkedList are: "); // 2 1 3 4 5
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;

		}
	}
}
