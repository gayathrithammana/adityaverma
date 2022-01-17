package treeDFS.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: find all paths from root-to-leaf such that the sum of all the node values = given sum
 * Problem 2: return all root-to-leaf paths
 * Problem 3: find root-to-leaf path with max sum
 * use DFS
 * 
 * 1. create a function takes sum, node, current list, result list
 * 2. if node == null return  
 * 3. add node to current list
 * 4. if val == sum and left, right == null add current list to result list
 * 5. else recursive call {sum, node.left, current list, result list}
 * 						  {sum, node.right, current list, result list}	
 * 6. remove last element from current list
 */ 

/**
 * Time Complexity O(N^2) - we traverse each node once and for every leaf node we have to store its path
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

public class AllPathsSum {
	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();

		List<Integer> currentPath = new ArrayList<Integer>();	//to save visited nodes

		findPathsRecursive(root, sum, currentPath, allPaths);

		return allPaths;
	}

	private static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath,
			List<List<Integer>> allPaths) {
		if(root == null)
			return;
		
		currentPath.add(root.val);	//save visited nodes
		
		if(root.val == sum && root.left == null && root.right == null)
			allPaths.add(new ArrayList<Integer>(currentPath));
		else {
			findPathsRecursive(root.left, sum - root.val, currentPath, allPaths);
			findPathsRecursive(root.right, sum - root.val, currentPath, allPaths);
		}
		
		currentPath.remove(currentPath.size() - 1);	//it means it reached leaf. remove it from list
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);	//[[12, 7, 4], [12, 1, 10]]
	}
}
