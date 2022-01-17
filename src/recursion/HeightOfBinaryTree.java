package recursion;

public class HeightOfBinaryTree {
	
	static int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
	}

}

class Node{
	int val;
	Node left;
	Node right;
	
	Node(){
		
	}
	
	Node(int val){
		this.val = val;
	}
	
	Node(int val, Node left, Node right){
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
