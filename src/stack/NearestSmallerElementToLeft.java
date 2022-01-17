package stack;

import java.util.Stack;

/**
 * Nearest smaller to left OR
 * smaller element of left array from current position
 * same as next element to right 
 * only change for loop from 0 to len(left -> right) and check smallest
 * 
 * Usage of stack: push every element and always keep smaller element at top(pop greater elements)
 */
public class NearestSmallerElementToLeft {
	private static int[] smaller(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			int currentElem = arr[i];
			if(s.isEmpty())
				result[i] = -1;
			
			else if(s.size() > 0 && s.peek() < currentElem) //if element in stack < the current element
				result[i] = s.peek();				   		//add it to result
			
			else if(s.size() > 0 && s.peek() >= currentElem) {
				//delete elements from stack if element in stack
				// > the current element 
				while(s.size() > 0 && s.peek() >= currentElem)
					s.pop();
				
				//repeat above 2 steps 
				if(s.isEmpty())
					result[i] = -1;
				else
					result[i] = s.peek();			
			}	
			
			s.push(currentElem);	//add to stack always
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] result = smaller(new int[] {4, 5, 2, 10, 8});	//-1 4 -1 2 2 
		for(int i:result)
			System.out.println(i);
	}
}
