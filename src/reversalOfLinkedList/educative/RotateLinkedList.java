package reversalOfLinkedList.educative;

/**
 * Time Complexity O(N) 
 * Space Complexity O(1)
 */
public class RotateLinkedList {
	
	private static ListNode rotate(ListNode head, int k) {
		if(head == null || head.next == null || k <= 0)
			return head;
		
		//1.find length of linked list
		int n = 1;
		ListNode temp = head;
		while(temp.next != null) {
			n++;
			temp = temp.next;
		}
		
		temp.next = head;	//2.make it circular list		
		k %= n;
		ListNode moveNode = head;
		for(int i = 0; i < n-k-1; i++) {
			moveNode = moveNode.next;
		}
		
		head = moveNode.next;
		moveNode.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);

	    ListNode result = rotate(head, 3);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }
	  }
	
	/**
	 * 1(h) -> 2 -> 3 -> 4 -> 5 -> 6(temp) -> null (len = 6)
	 * 1(h) -> 2 -> 3 -> 4 -> 5 -> 6 ->1 (circular)
	 * 1(h) -> 2 -> 3(m) -> 4 -> 5 -> 6 ->1
	 * 1 -> 2 -> 3(m) -> 4(h) -> 5 -> 6 ->1
	 * 4(h) -> 5 -> 6 ->1 -> 2 -> 3(m) -> null
	 */
}
