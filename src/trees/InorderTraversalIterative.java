package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Leetcode 94. Binary Tree Inorder Traversal
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * 
 * 1. Use stack
 * 2. while(current!= null || stack is not Empty)
 * 		while(current != null )
 * 			Push all left while null
 *      Pop one element and add to result
 *      current = current.right;
 *
 */

public class InorderTraversalIterative {

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(A == null)
            return list;
            
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = A;
        while(current != null || s.size() > 0){
            while(current != null){
                s.push(current);
                current = current.left;
            }
            
            current = s.pop();
            list.add(current.val);
            current = current.right;
        }
        
        return list;
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
