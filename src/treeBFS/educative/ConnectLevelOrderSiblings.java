package treeBFS.educative;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

	private static void connect(TreeNode1 root) {
		if (root == null)
			return;

		Queue<TreeNode1> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size(); // size of elements at each level
			TreeNode1 prev = null;
			for (int i = 0; i < size; i++) {
				TreeNode1 currentNode = q.poll();
				if (prev != null)
					prev.next = currentNode;
				prev = currentNode;

				if (currentNode.left != null)
					q.offer(currentNode.left);

				if (currentNode.right != null)
					q.offer(currentNode.right);
			}

		}
	}

	private static void connectAll(TreeNode1 root) {
		if (root == null)
			return;

		Queue<TreeNode1> q = new LinkedList<>();
		q.offer(root);

		TreeNode1 currentNode = null;
		TreeNode1 prev = null;
		while (!q.isEmpty()) {
			currentNode = q.poll();
			if (prev != null)
				prev.next = currentNode;
			prev = currentNode;

			if (currentNode.left != null)
				q.offer(currentNode.left);

			if (currentNode.right != null)
				q.offer(currentNode.right);

		}
	}

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(12);
		root.left = new TreeNode1(7);
		root.right = new TreeNode1(1);
		root.left.left = new TreeNode1(9);
		root.right.left = new TreeNode1(10);
		root.right.right = new TreeNode1(5);
		connect(root);
		System.out.println("Level order traversal using 'next' pointer: ");
		root.printLevelOrder();

		System.out.println("connect all");
		System.out.println("Level order traversal using 'next' pointer: ");
		connectAll(root);
		root.printTree();
	}
}

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1 next;

	TreeNode1(int x) {
		val = x;
		left = right = next = null;
	}

	// level order traversal using 'next' pointer
	public void printLevelOrder() {
		TreeNode1 nextLevelRoot = this;
		while (nextLevelRoot != null) {
			TreeNode1 current = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if (nextLevelRoot == null) {
					if (current.left != null)
						nextLevelRoot = current.left;
					else if (current.right != null)
						nextLevelRoot = current.right;
				}
				current = current.next;
			}
			System.out.println();
		}
	}
	
	public void printTree() {
	    TreeNode1 current = this;
	    System.out.print("Traversal using 'next' pointer: ");
	    while (current != null) {
	      System.out.print(current.val + " ");
	      current = current.next;
	    }
	  }
};