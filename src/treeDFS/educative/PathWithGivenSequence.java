package treeDFS.educative;

/**
 * Time Complexity O(N) - we traverse each node once.
 * Space Complexity O(N) - in worst case, the space will be used to store the recursion stack. 
 * 						   WC happens when the tree is a linked list(i.e., when every node has only one child)
 */

class PathWithGivenSequence {
	
	public static boolean findPath(TreeNode root, int[] sequence) {
		if(root == null)
			return sequence.length == 0;
		
		return findPathWithIndex(root, sequence, 0);
	}

	private static boolean findPathWithIndex(TreeNode root, int[] sequence, int i) {
		if(root == null)
			return false;
		
		if(i >= sequence.length || root.val != sequence[i])	
			return false;
		
		if(i == sequence.length - 1 && root.left == null & root.right == null)	//reached leaf and found match
			return true;
		
		return findPathWithIndex(root.left, sequence, i + 1) || 
			   findPathWithIndex(root.right, sequence, i + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));	//false
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));	//true
	}
}
