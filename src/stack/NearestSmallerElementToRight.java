package stack;

import java.util.Stack;

/**
 * Nearest smaller to right OR
 * smaller element of right array from current position
 * same as next greater element to right 
 * only loop from right to left and check for smallest
 * 
 * Usage of stack: push every element and always keep smaller element at top(pop greater elements)
 */
public class NearestSmallerElementToRight {
	private static int[] smaller(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=arr.length-1;i>=0;i--) {
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
		int[] result = smaller(new int[] {4, 5, 2, 10, 8});	//2 2 -1 8 -1
		for(int i:result)
			System.out.println(i);
	}
}
