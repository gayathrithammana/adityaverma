package treeBFS.educative;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same as level order traversal
 * keep track of depth and no need to add list of all nodes to result
 * find first leaf node and return depth
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
public class MinimumDepthOfBT {
	public static int findMinDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size(); // size of elements at each level
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = q.poll();
				if (currentNode.left == null && currentNode.right == null)
					return depth;
				
				if (currentNode.left != null)
					q.offer(currentNode.left);

				if (currentNode.right != null)
					q.offer(currentNode.right);
				
			}
		}

		return depth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + findMinDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + findMinDepth(root));
	}
}
