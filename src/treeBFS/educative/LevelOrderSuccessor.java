package treeBFS.educative;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same as level order traversal
 * dont need to keep track of size and no need to add elements to list
 * when the current element is key break the loop 
 * and return q.poll
 * 
 * Use BFS technique
 * 
 * 1. Add rootNode to queue
 * 2. Iterate while queue is empty
 * 3. keep track of level
 * 4. In each iteration count no.of elements(size) in queue
 * 5. remove size of elements from queue in a loop
 *    - if no children return level
 *    - else continue to add left, right and repeat from 4
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - n/2 elements in queue 
 */

public class LevelOrderSuccessor {
	public static TreeNode findSuccessor(TreeNode root, int key) {
		if (root == null)
			return null;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode currentNode = q.poll();

			if (currentNode.left != null)
				q.offer(currentNode.left);

			if (currentNode.right != null)
				q.offer(currentNode.right);

			if (currentNode.val == key) {
				break;
			}

		}

		return q.peek();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}
}
