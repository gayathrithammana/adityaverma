package recursion;

import java.util.Stack;

public class SortStackUsingRecursion {
	private static void sort(Stack<Integer> s) {
		int len = s.size();
		if(len == 1)
			return;
		
		int temp = s.pop();
		sort(s);
		insert(s, temp);
	}

	private static void insert(Stack<Integer> s, int temp) {
		int len = s.size();
		if(len == 0 || s.peek() <= temp) {
			s.push(temp);
			return;
		}
		
		int temp1 = s.pop();
		insert(s, temp);
		s.push(temp1);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(1);
		s.push(5);
		s.push(2);
		
		sort(s);
		for(int i:s)
			System.out.println(i);
	}
}
