package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * same as level order traversal
 * when i < size - 1 add it to result
 * 
 * Use BFS technique
 * 
 * 1. Add rootNode to queue
 * 2. Iterate while queue is empty
 * 3. In each iteration count no.of elements(size) in queue
 * 4. remove size of elements from queue in a loop
 *    - add its children
 *    - when i < size - 1 add it to result
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - result list with all nodes n + n/2 elements in queue 
 */

class RightViewTree {
	public static List<TreeNode> traverse(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				TreeNode currentNode = q.poll();
				
				if(currentNode.left != null)
					q.offer(currentNode.left);
				
				if(currentNode.right != null)
					q.offer(currentNode.right);
				
				if(i == size - 1)
					result.add(currentNode);
				
			}
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
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = RightViewTree.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}
}
