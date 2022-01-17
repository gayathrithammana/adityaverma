package treeBFS.educative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * From leetcode 429. N-ary Tree Level Order Traversal
 * Same as Binary tree level order traversal instead of adding left, right add
 * all children
 * 
 * Use BFS technique
 * 
 * 1. Add rootNode to queue 2. Iterate while queue is empty 3. In each iteration
 * count no.of elements(size) in queue 4. remove size of elements from queue in
 * a loop - add its children
 */

public class NarrayTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(Node root) {
        //use BFS technique
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> oneLevel = new ArrayList<Integer>();
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                oneLevel.add(temp.val);
                
//                 if(temp.left != null)
//                     q.offer(temp.left);
                
//                 if(temp.right != null)
//                     q.offer(temp.right);
                
                //instead of left and right add all children
                if(temp.children != null){
                    List<Node> children = temp.children;
                    for(Node m :children){
                        q.offer(m);
                    }
                }
                
                
            }
            
            result.add(oneLevel);
        }
        
        return result;
    }
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};