package reversalOfLinkedList.educative;

/**
 * Time Complexity O(N) 
 * Space Complexity O(1)
 */

/**
problem 1:reverse if p-q positions
problem 2:reverse first k elements(p=1, q=k)
problem 3:  

		1. If ‘n’ is even, reverse the list in a group of n/2 nodes.
			head = reverse(head, 1, n/2)
			head = reverse(head, n/2+1, n)
		2. If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.
			head = reverse(head, 1, n/2)
			head = reverse(head, n/2+2, n)
 */
public class ReverseSubList {
	
	/**
	 * @param head
	 * p, q positions
	 */
	public static ListNode reverse(ListNode head, int p, int q) {
		
		if(p == q)
			return head;
		
		ListNode prev = null;
		ListNode current = head;
		
		for(int i = 0;current != null && i < p - 1; i++) {
			prev = current;
			current = current.next;
		}
			
		ListNode beforeP = prev;	//p - 1 th element
		ListNode atP = current;		//p th element
		ListNode next = null;
		
		for(int i = 0; current != null && i < q - p + 1 ;i++) {
			next = current.next; // temporarily store the next node
			current.next = prev; // reverse the current node
			prev = current; // before we move to the next node, point previous to the current node
			current = next; // move on the next node
		}
		
		if(beforeP != null)
			beforeP.next = prev;
		else
			head = prev;	//if p == 1 we are changing the first node of ll ex: ([3,5], 1, 2)
		
		atP.next = current;
		
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = reverse(head, 2, 4);
		System.out.print("Nodes of the reversed LinkedList are: ");		//1 4 3 2 5
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;

		}
		System.out.println();
		head = new ListNode(3);
		head.next = new ListNode(5);
		result = reverse(head, 1, 2);
		System.out.print("Nodes of the reversed LinkedList are: ");		//5 3
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;

		}
	}
}
