package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Same as level order traversal
 * instead of adding all elements to list just track sum then cal avg
 * 
 * Use BFS technique
 * 
 * 1. Add rootNode to queue
 * 2. Iterate while queue is empty
 * 3. In each iteration count no.of elements(size) in queue
 * 4. remove size of elements from queue in a loop
 *    - add to sum
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - result list with all nodes n + n/2 elements in queue 
 */
public class LevelAveragesInaBT {
	public static List<Double> avg(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		if(root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();	//size of elements at each level
			double sum = 0.0;
			for(int i=0;i<size;i++) {
				TreeNode currentNode = q.poll();
				sum += currentNode.val; 
				
				if(currentNode.left != null)
					q.offer(currentNode.left);
				
				if(currentNode.right != null)
					q.offer(currentNode.right);
			}
			
			result.add(sum/size);
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.left.right = new TreeNode(2);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    List<Double> result = avg(root);
	    System.out.print("Level averages are: " + result);
	}
}
