package treeDFS.educative;

/**
 * we can use DFS(we dont need to store all visited nodes. we can just work with sum - node.val)
 * 1.start DFS at root
 * 2.if current node is not a leaf 
 * 		- make recursive call for left & right with sum = sum - node.value
 * 3.At every step, if current node is leaf and value = given sum then return true
 *   otherwise return false
 */

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

public class TreePathSum {

	public static boolean hasPath(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		if(root.val == sum && root.left == null && root.right == null)
			return true;
		
		return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + hasPath(root, 23));	//true 12,1,10
		System.out.println("Tree has path: " + hasPath(root, 16));	//false
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
