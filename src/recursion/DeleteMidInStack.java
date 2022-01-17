package recursion;

import java.util.Stack;

public class DeleteMidInStack {
	private static void deleteMid(Stack<Integer> s, Integer pos) {
		if(pos == 1) {
			s.pop();
			return;
		}
		
		int temp = s.pop();
		deleteMid(s, pos - 1);
		s.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		
		deleteMid(s, (s.size() / 2) + 1);	//5 4 2 1
		for(int i:s)
			System.out.println(i);
	}
}
