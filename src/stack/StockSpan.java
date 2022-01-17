package stack;

import java.util.Stack;

/** Consecutive smaller or equal element before it
 * i.e., we need to find how many elements smaller or equal to it to left
 * i.e., we need to count till we find greater element than it 
 * and index of greater element - current element will give the count
 * 
 * Same as: Nearest greater to left 
 * instead of storing element store index and calculate count
 */
public class StockSpan {
	private static int[] greater(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			int currentElem = arr[i];
			if(s.isEmpty()) {
				result[i] = -1;
			}
			
			else if(s.size() > 0 && arr[s.peek()] > currentElem) //if element in stack > the current element
				result[i] = s.peek();				   		//add it to result
			
			else if(s.size() > 0 && arr[s.peek()] <= currentElem) {
				//delete elements from stack if element in stack
				// < the current element 
				while(s.size() > 0 && arr[s.peek()] <= currentElem) {
					s.pop();
				}
				
				//repeat above 2 steps 
				if(s.isEmpty())
					result[i] = -1;
				else
					result[i] = s.peek();			
			}	
			
			s.push(i);
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] result = greater(new int[] {100, 80, 60, 70, 60, 75, 85});	//-1 0 1 1 3 1 0
		for(int i=0;i<result.length;i++)
			System.out.println(i - result[i]);	//1 1 1 2 1 4 6
	}
}
