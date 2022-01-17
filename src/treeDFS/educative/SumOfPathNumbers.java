package treeDFS.educative;

/**
 * we can use DFS(we dont need to store all visited nodes. we can just work with sum = sum * 10 + root.val)
 * 1.start DFS at root
 * 2. if root === null return 0
 * 3.At every step, cal sum = sum * 10 + root.val
 * 4.if current node is a leaf return sum
 * 	 else make recursive call for left +  right with sum
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */
public class SumOfPathNumbers {
	public static int findSumOfPathNumbers(TreeNode root) {
		return findSumOfPaths(root, 0);
	}

	private static int findSumOfPaths(TreeNode root, int sum) {
		
		if(root == null)
			return 0;
		
		sum = sum * 10 + root.val;
		
		if(root.left == null && root.right == null) {
			return sum;
		}
		
		return findSumOfPaths(root.left, sum) + 
			   findSumOfPaths(root.right, sum);
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));	//101+ 116+115 = 332
	}
}
