package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**zigzag means alternate direction'
 * l -> r, r->l, l -> r, r->l
 * 
 * same as leverl order traversal
 * 
 * based on a flag add oneLevel elements at beginning or end
 * Use BFS technique
 * 
 * 1. Add rootNode to queue
 * 2. Iterate while queue is empty
 * 3. In each iteration count no.of elements(size) in queue
 * 4. remove size of elements from queue in a loop
 *    - add its children
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - result list with all nodes n + n/2 elements in queue 
 */
public class ZigZagTraversal {
	public static List<List<Integer>> zigzagTraverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean leftToRight = true;
		while(!q.isEmpty()) {
			int size = q.size();	//size of elements at each level
			List<Integer> oneLevel = new ArrayList<Integer>(size);
			for(int i=0;i<size;i++) {
				TreeNode currentNode = q.poll();
				if(leftToRight)
					oneLevel.add(currentNode.val);
				else
					oneLevel.add(0, currentNode.val);
				
				if(currentNode.left != null)
					q.offer(currentNode.left);
				
				if(currentNode.right != null)
					q.offer(currentNode.right);
			}
			
			result.add(oneLevel);
			leftToRight = !leftToRight;
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    root.right.left.left = new TreeNode(20);
	    root.right.left.right = new TreeNode(17);
	    List<List<Integer>> result = zigzagTraverse(root);
	    System.out.println("Zigzag traversal: " + result);
	}
}
