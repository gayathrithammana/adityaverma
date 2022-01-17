package stack;

/**
 * Nearest greater to left OR
 * greater element of left array from current position
 * same as element to right 
 * only change for loop from 0 to len(left -> right)
 * 
 * Usage of stack: push every element and always keep greater element at top(pop smaller elements)
 */
import java.util.Stack;

public class NearestGreaterElementToLeft {
	
	private static int[] greater(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			int currentElem = arr[i];
			if(s.isEmpty())
				result[i] = -1;
			
			else if(s.size() > 0 && s.peek() > currentElem) //if element in stack > the current element
				result[i] = s.peek();				   		//add it to result
			
			else if(s.size() > 0 && s.peek() <= currentElem) {
				//delete elements from stack if element in stack
				// < the current element 
				while(s.size() > 0 && s.peek() <= currentElem)
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
		int[] result = greater(new int[] {1, 3, 2, 4});	//-1 -1 3 -1
		for(int i:result)
			System.out.println(i);
	}

}
