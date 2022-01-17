package treeDFS.educative;

/**
 * Given a binary tree, find the root-to-leaf path with the maximum sum.
 * 
 * same as All paths
 * use DFS
 */

public class MaximumSumRootToLeaf {
	public static int findPaths(TreeNode root) {
		return findPathsRecursive(root, 0, 0);
	}

	private static int findPathsRecursive(TreeNode root, int maxSum, int sum) {
		if(root == null)
			return sum;
		
		sum += root.val;
		
		if(root.left == null && root.right == null)
			maxSum = Math.max(maxSum, sum);
		else {
			maxSum = Math.max(findPathsRecursive(root.left, maxSum, sum), 
								findPathsRecursive(root.right, maxSum, sum));
		}
		
		sum -= root.val;	//it means it reached leaf. remove it from sum
		
		return maxSum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = findPaths(root);
		System.out.println("Max sum :" + sum);	//23
		
		root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		sum = findPaths(root);
		System.out.println("Max sum :" + sum);	//8
	}
}
