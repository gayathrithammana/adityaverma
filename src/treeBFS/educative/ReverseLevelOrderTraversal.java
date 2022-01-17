package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** traverse bootom-up
 * 
 * Same as Level order traversal
 * just add to beginning - result.add(0, list);
 *  
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

public class ReverseLevelOrderTraversal {
	public static List<List<Integer>> reverseTraverse(TreeNode root) {
		//as we need to add to beginning of the list we will use LL
		//if ArrayList is used it will shift the elements
		//LL will be better as shifting of elements is not required
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();	
		//List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();	//size of elements at each level
			List<Integer> oneLevel = new ArrayList<Integer>(size);
			for(int i=0;i<size;i++) {
				TreeNode currentNode = q.poll();
				oneLevel.add(currentNode.val);
				
				if(currentNode.left != null)
					q.offer(currentNode.left);
				
				if(currentNode.right != null)
					q.offer(currentNode.right);
			}
			
			result.add(0, oneLevel);
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
		List<List<Integer>> result = reverseTraverse(root);
		System.out.println("Level order traversal: " + result);
	}
}
