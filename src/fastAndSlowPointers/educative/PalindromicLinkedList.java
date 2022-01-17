package fastAndSlowPointers.educative;

/**
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class PalindromicLinkedList {

	public static boolean isPalindrome(ListNode head) {

		// 1.find middle node
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 2.reverse second half
		ListNode secondHalfHead = reverse(slow);
		ListNode copySecondHalfHead = secondHalfHead;

		while (head != null && secondHalfHead != null) {
			if (head.value != secondHalfHead.value)
				break;
			head = head.next;
			secondHalfHead = secondHalfHead.next;
		}

		// 3.revert reverse of second half
		reverse(copySecondHalfHead);

		if (head == null || secondHalfHead == null)
			return true;

		return false;
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
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));	//true

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));	//false
	}

}
