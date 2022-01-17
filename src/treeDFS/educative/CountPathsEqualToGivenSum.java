package treeDFS.educative;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/** Leetcode:437. Path Sum III
 * use DFS
 * 
 * 1. create a function takes node, target sum, current list
 * 2. if node == null return  0
 * 3. add node to current list
 * 4. add iterator to navigate to all prev 
 * 	  at each step cal sum and compare with target sum
 *    if found increase count 
 * 5. recursive call count += {node.left, target sum, current list}
 * 					 count += {node.right, target sum, current list}
 * 6. remove last element from current list
 */ 

/**
 * Time Complexity O(N^2) - we traverse each node once and for every leaf node we have to store its path
 * but if it is a balaned tree current path will be height = O(logN). Hence in best case O(NlogN)
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */
public class CountPathsEqualToGivenSum {
	public static int countPaths(TreeNode root, int targetSum) {
		List<Integer> currentPath = new LinkedList<Integer>(); // to save visited nodes

		return findPathsRecursive(root, targetSum, currentPath);

	}

	private static int findPathsRecursive(TreeNode root, int targetSum, List<Integer> currentPath) {
		if (root == null)
			return 0;

		currentPath.add(root.val); // save visited nodes
		
		int count = 0;
		int sum = 0;
		ListIterator<Integer> iterator = currentPath.listIterator(currentPath.size());
		
		while(iterator.hasPrevious()) {
			sum += iterator.previous();
			
			if(sum == targetSum)		
				count++;					//dont break the loop ex:{0, 1, 1}
		}
		
		count += findPathsRecursive(root.left, targetSum, currentPath);
		count += findPathsRecursive(root.right, targetSum, currentPath);

		currentPath.remove(currentPath.size() - 1); // it means it reached leaf. remove it from list
		
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + countPaths(root, 11));
	}
}
