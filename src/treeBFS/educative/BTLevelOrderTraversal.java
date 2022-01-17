package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
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
public class BTLevelOrderTraversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();	//size of elements at each level
			List<Integer> oneLevel = new ArrayList<Integer>(size);
			for(int i=0;i<size;i++) {
				
				TreeNode currentNode = q.poll();
				
				oneLevel.add(currentNode.val);	//add to result
				
				if(currentNode.left != null)	//add left and right to queue
					q.offer(currentNode.left);
				
				if(currentNode.right != null)
					q.offer(currentNode.right);
			}
			
			result.add(oneLevel);
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = traverse(root);
		System.out.println("Level order traversal: " + result);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};
