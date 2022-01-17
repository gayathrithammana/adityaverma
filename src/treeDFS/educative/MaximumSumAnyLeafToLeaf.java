package treeDFS.educative;

/** Find max sum of a BT,  between any two nodes in a tree.
 * doesn�t necessarily pass through the root. 
 * there are at least two leaf nodes in the given tree.
 * 
 * use dfs
 * 1. Create a function and static variable to track maxSum
 * 2. function should cal and return max sum of the tree(max(lS, rS) + root.val)
 *    - after cal lS, rS ignore -ve values
 *    - i.e., lS = max(0, lS)
 * 3. same function should cal and update max sum(diameter = lS + rS + 1)
 * 
 * Time Complexity O(N) - we traverse each node once
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

public class MaximumSumAnyLeafToLeaf {
	static int maxSum;
	public static int findMaximumPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;	//as it is a global variable it need to be reinitialized for every test case
		calSum(root);
		return maxSum;
	}

	private static int calSum(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftSum = calSum(root.left);
		int rightSum = calSum(root.right);
		
		int temp = Math.max(leftSum, rightSum) + root.val;
		if(root.left == null && root.right == null)
			temp = Math.max(temp, root.val);
		
		int ans = Math.max(temp, leftSum + rightSum + root.val);
		maxSum = Math.max(ans, maxSum);
		
		return ans;
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

		root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));
	}
}
