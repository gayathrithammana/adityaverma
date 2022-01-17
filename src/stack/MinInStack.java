package stack;

import java.util.Stack;

public class MinInStack {
	
	static Stack<Integer> s = new Stack<Integer>();
	static int min;
	
	public static int getMin() {
		if(s.size() == 0)
			return -1;
		
		return min;
	}
	
	public static void push(int x) {
		if(s.size() == 0) {
			s.push(x);
			min = x;
		} else {
			if(x >= min)
				s.push(x);
			else if(x < min) {
				s.push(2 * x - min);		//2x - min
				min = x;
			}
		}
	}
	
	public static void pop() {
		if(s.size() == 0)
			return;
		else {
			if(s.peek() >= min)
				s.pop();
			else if(s.peek() < min) {
				min = 2 * min - s.peek();	//2min - s.peek()
				s.pop();
			}
		}
	}
	
	public static int top() {
		if(s.size() == 0)
			return -1;
		else {
			if(s.peek() >= min)
				return s.pop();
			else if(s.peek() < min)
				return min;
		}
		return -1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
