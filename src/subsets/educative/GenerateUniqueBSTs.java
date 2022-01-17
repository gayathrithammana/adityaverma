package subsets.educative;

import java.util.ArrayList;
import java.util.List;

/** Leetcode 95. Unique Binary Search Trees II
 * 
 * from educative same as  Different Ways to Add Parentheses/Different ways to Evaluate expression
 * 
 *  1. if start > end add null to result and return
 *  2. else
 *     for each i in start -> end
 *     - solve left part solve(start, i-1)
 *     - solve right part solve(i+1, end)
 *  3. for each left and right part 
 *     construct treenode of i
 *     add left node
 *     add right node
 *  4. add to result list
 *  
 * Time Complexity O(N * 2^N) 
 * Space Complexity O(2^N)
 */

public class GenerateUniqueBSTs {
	public static List<TreeNode> generateUniqueTrees(int n) {
		if(n <= 0)
			return new ArrayList<TreeNode>();
		
		return generate(1, n);
	}
	

	private static List<TreeNode> generate(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start > end) {
			result.add(null);
			return result;
		} 
		
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftTrees = generate(start, i-1);
			List<TreeNode> rightTrees = generate(i+1, end);
			
			for(TreeNode left: leftTrees) {
				for(TreeNode right:rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<TreeNode> result = generateUniqueTrees(2);
		System.out.print("Total trees: " + result.size());
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
