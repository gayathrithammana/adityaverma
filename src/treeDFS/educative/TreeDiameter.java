package treeDFS.educative;

/** Find diameter of a BT, length of the longest path between any two nodes in a tree.
 * doesn’t necessarily pass through the root. 
 * 
 * there are at least two leaf nodes in the given tree.
 * use dfs
 * 1. While calculating max height we can calculate diamter too
 * 2. Create a function and static variable diameter
 * 3. function should cal and return height of the tree(height = max(lh, rh) + 1)
 * 4. same function should cal and update max diameter(diameter = lh + rh + 1 and find max diameter)
 */

/**
 * Time Complexity O(N) - we traverse each node once
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

public class TreeDiameter {
	private static int maxDiameter = 0;
	
	public static int findDiameter(TreeNode root) {
		calculateHeight(root);
		return maxDiameter;
	}

	private static int calculateHeight(TreeNode currentNode) {
		if (currentNode == null)
			return 0;

		int leftTreeHeight = calculateHeight(currentNode.left);
		int rightTreeHeight = calculateHeight(currentNode.right);

		// diameter at the current node will be equal to the height of left subtree +
		// the height of right sub-trees + '1' for the current node
		int diameter = leftTreeHeight + rightTreeHeight + 1;

		// update the global tree diameter
		maxDiameter = Math.max(maxDiameter, diameter);

		// height of the current node will be equal to the maximum of the heights of
		// left or right subtrees plus '1' for the current node
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));	//5
		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));	//7
	}
}
