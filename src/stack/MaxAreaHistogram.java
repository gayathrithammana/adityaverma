package stack;

import java.util.Stack;

/**
 *  Index of Smallertoleft - Index of smallertoRight - 1 = width
 *  given array = height
 *  area = height * width;
 */

public class MaxAreaHistogram {
	private static int[] smallerToLeft(int[] arr) {
		int left[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		int pesudoIndex = -1;
		for(int i=0;i<arr.length;i++) {
			int currentElem = arr[i];
			if(s.isEmpty())
				left[i] = pesudoIndex;
			
			else if(s.size() > 0 && arr[s.peek()] < currentElem) //if element in stack < the current element
				left[i] = s.peek();				   		//add it to left
			
			else if(s.size() > 0 && arr[s.peek()] >= currentElem) {
				//delete elements from stack if element in stack
				// > the current element 
				while(s.size() > 0 && arr[s.peek()] >= currentElem)
					s.pop();
				
				//repeat above 2 steps 
				if(s.isEmpty())
					left[i] = pesudoIndex;
				else
					left[i] = s.peek();			
			}	
			
			s.push(i);	//add to stack always
			
		}
		
		return left;
	}
	
	private static int[] smallerToRight(int[] arr) {
		int len = arr.length;
		int right[] = new int[len];
		Stack<Integer> s = new Stack<Integer>();
		int pesudoIndex = len;
		for(int i=len-1;i>=0;i--) {
			int currentElem = arr[i];
			if(s.isEmpty())
				right[i] = pesudoIndex;
			
			else if(s.size() > 0 && arr[s.peek()] < currentElem) //if element in stack < the current element
				right[i] = s.peek();				   		//add it to right
			
			else if(s.size() > 0 && arr[s.peek()] >= currentElem) {
				//delete elements from stack if element in stack
				// > the current element 
				while(s.size() > 0 && arr[s.peek()] >= currentElem)
					s.pop();
				
				//repeat above 2 steps 
				if(s.isEmpty())
					right[i] = pesudoIndex;
				else
					right[i] = s.peek();			
			}	
			
			s.push(i);	//add to stack always
			
		}
		
		return right;
	}

	public static void main(String[] args) {
		int[] input = new int[] {6, 2, 5, 4, 5, 1, 6};
		int len = input.length;
		int[] left = smallerToLeft(input);	    //-1 -1 1 1 3 -1 5
		int[] right = smallerToRight(input);	// 1  5 3 5 5  7 7 
		
		int[] width = new int[len];
		int[] area = new int[len];
		for(int i=0;i<len;i++)
			width[i] = right[i] - left[i] - 1;	//1 5 1 3 1 7 1 		
		for(int i=0;i<len;i++)			
			area[i] = input[i] * width[i];	    //6 10 5 12 5 7 6
		
		//find max area
		int max = Integer.MIN_VALUE;
		for(int oneArea : area) {
			max = Math.max(max, oneArea);
		}
		
		System.out.println(max);	//12
	}
}
