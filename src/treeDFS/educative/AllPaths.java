package treeDFS.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * same as All paths sum dont track sum
 * use DFS
 * 
 * 1. create a function takes node, current list, result list
 * 2. if node == null return  
 * 3. add node to current list
 * 4. if left, right == null add current list to result list
 * 5. else recursive call { node.left, current list, result list}
 * 						  {node.right, current list, result list}	
 * 6. remove last element from current list
 */ 

/**
 * Time Complexity O(N^2) - we traverse each node once and for every leaf node we have to store its path
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

public class AllPaths {
	public static List<List<Integer>> findPaths(TreeNode root) {
		List<List<Integer>> allPaths = new ArrayList<>();

		List<Integer> currentPath = new ArrayList<Integer>();	//to save visited nodes

		findPathsRecursive(root, currentPath, allPaths);

		return allPaths;
	}

	private static void findPathsRecursive(TreeNode root, List<Integer> currentPath,
			List<List<Integer>> allPaths) {
		if(root == null)
			return;
		
		currentPath.add(root.val);	//save visited nodes
		
		if(root.left == null && root.right == null)
			allPaths.add(new ArrayList<Integer>(currentPath));
		else {
			findPathsRecursive(root.left, currentPath, allPaths);
			findPathsRecursive(root.right, currentPath, allPaths);
		}
		
		currentPath.remove(currentPath.size() - 1);	//it means it reached leaf. remove it from list
	}
	
	//leetcode 257. Binary Tree Paths
	//return list of paths in strings ["1->2->5", "1->3"]
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<String>();
        if(root != null){
            StringBuilder sb = new StringBuilder();
		    findPathsRecursive(root, sb, allPaths);
        }

		return allPaths;
    }
    
    public static void findPathsRecursive(TreeNode root, StringBuilder currentPath,
			List<String> allPaths) {
		
        if(root == null)
			return;
        
        int len = currentPath.length();
        currentPath.append(root.val);
        
		if(root.left == null && root.right == null){
            allPaths.add(currentPath.toString());
        }
        else{
            currentPath.append("->");
            findPathsRecursive(root.left, currentPath, allPaths);
            findPathsRecursive(root.right, currentPath, allPaths);
        }
		
        currentPath.setLength(len);	//it means it reached leaf. remove it from list
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = findPaths(root);
		System.out.println("Tree paths " + ": " + result);	//[[12, 7, 4], [12, 1, 10], [12, 1, 5]]
	}
}
