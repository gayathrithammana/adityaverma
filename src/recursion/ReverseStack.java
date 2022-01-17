package recursion;

import java.util.Stack;

public class ReverseStack {
	private static void reverse(Stack<Integer> s) {
		if(s.size() == 1)
			return;
		
		int temp = s.pop();
		reverse(s);
		insert(s, temp);
	}
	
	private static void insert(Stack<Integer> s, int elem) {
		if(s.size() == 0) {
			s.push(elem);
			return;
		}
		
		int temp = s.pop();
		insert(s, elem);
		s.push(temp);
	}
	
	

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		
		reverse(s);	//1 2 3 4 5
		for(int i:s)
			System.out.println(i);
	}
}
