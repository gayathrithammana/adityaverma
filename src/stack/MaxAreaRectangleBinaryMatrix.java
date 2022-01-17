package stack;

import java.util.Stack;

/**
 * same as Max Area Histogram build all possible histogram from matrix and
 * calculate area(2D -> 1D)
 */
public class MaxAreaRectangleBinaryMatrix {
	private static int[] smallerToLeft(int[] arr) {
		int left[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		int pesudoIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			int currentElem = arr[i];
			if (s.isEmpty())
				left[i] = pesudoIndex;

			else if (s.size() > 0 && arr[s.peek()] < currentElem) // if element in stack < the current element
				left[i] = s.peek(); // add it to left

			else if (s.size() > 0 && arr[s.peek()] >= currentElem) {
				// delete elements from stack if element in stack
				// > the current element
				while (s.size() > 0 && arr[s.peek()] >= currentElem)
					s.pop();

				// repeat above 2 steps
				if (s.isEmpty())
					left[i] = pesudoIndex;
				else
					left[i] = s.peek();
			}

			s.push(i); // add to stack always

		}

		return left;
	}

	private static int[] smallerToRight(int[] arr) {
		int len = arr.length;
		int right[] = new int[len];
		Stack<Integer> s = new Stack<Integer>();
		int pesudoIndex = len;
		for (int i = len - 1; i >= 0; i--) {
			int currentElem = arr[i];
			if (s.isEmpty())
				right[i] = pesudoIndex;

			else if (s.size() > 0 && arr[s.peek()] < currentElem) // if element in stack < the current element
				right[i] = s.peek(); // add it to right

			else if (s.size() > 0 && arr[s.peek()] >= currentElem) {
				// delete elements from stack if element in stack
				// > the current element
				while (s.size() > 0 && arr[s.peek()] >= currentElem)
					s.pop();

				// repeat above 2 steps
				if (s.isEmpty())
					right[i] = pesudoIndex;
				else
					right[i] = s.peek();
			}

			s.push(i); // add to stack always

		}

		return right;
	}

	public static int calArea(int[] input) {
		int len = input.length;
		int[] left = smallerToLeft(input);
		int[] right = smallerToRight(input);

		int[] width = new int[len];
		int[] area = new int[len];
		for (int i = 0; i < len; i++)
			width[i] = right[i] - left[i] - 1;
		for (int i = 0; i < len; i++)
			area[i] = input[i] * width[i];

		// find max area
		int max = Integer.MIN_VALUE;
		for (int oneArea : area) {
			max = Math.max(max, oneArea);
		}

		return max;
	}

	public static void main(String[] args) {
		int n = 4; //rows
		int m = 4; //columns
		int[][] matrix = getInputMatrix();
		int[] temp = new int[m];

		// cal area for 1st row
		for (int j = 0; j < m; j++) {
			temp[j] = matrix[0][j];
		}
		
		int maxArea = calArea(temp);

		// cal area for other rows
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if(matrix[i][j] == 0)
					temp[j] = 0;
				else
					temp[j] = temp[j] + 1;
			}
			
			maxArea = Math.max(maxArea, calArea(temp));
		}

		System.out.println(maxArea);
	}

	private static int[][] getInputMatrix() {
		
		/**
		 * 0 1 1 0 -> 0 1 1 0					area = 2
		 * 1 1 1 1 -> 1 2 2 1(above row + 1) 	area = 4
		 * 1 1 1 1 -> 2 3 3 2(above row + 1) 	area = 8	<-
		 * 1 1 0 0 -> 3 4 0 0(above row + 1) 	area = 6
		 */
		
		int[][] matrix = new int[4][4];
		
		matrix[0] = new int[] {0, 1, 1, 0};
		matrix[1] = new int[] {1, 1, 1, 1};
		matrix[2] = new int[] {1, 1, 1, 1};
		matrix[3] = new int[] {1, 1, 0, 0};

		return matrix;
	}
}
