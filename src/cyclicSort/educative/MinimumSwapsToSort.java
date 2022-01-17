package cyclicSort.educative;
import java.util.HashMap;

/**
 * Minimum swaps required to sort an array 
 * 
 * Given array [7, 1, 3, 2, 4, 5, 6]
	i   arr                     swap (indices)
	0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
	1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
	2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
	3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
	4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
	5   [1, 2, 3, 4, 5, 6, 7]

 * https://www.youtube.com/watch?v=J9ikRMK8Yhs
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 * 
 * this problem is based on cyclic sort
 * step1: maintain a visited array
 * step2: while doing cyclic sort check if node is visited and requires swapping
 * 		  if requires swapping increase the count
 * 		  repeat step2 until next unvisited element is found
 */
public class MinimumSwapsToSort {
	
	public static int minSwaps(int[] arr) {
		boolean visited[] = new boolean[arr.length];
		int swapCount = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(visited[i] == false) {
				visited[i] = true;
				
				if(arr[i] == i+1)		//element is in correct place
					continue;
				else {					//element is not in correct place
					int temp = arr[i];
					int next;
					
					while(!visited[temp-1]) {
						visited[temp-1] = true;
						next = arr[temp-1];
						temp = next;
						swapCount++;
					}
				}
			}
		}
		
		return swapCount;
		
	}
	
	public static int minSwaps1(int[] arr) {
		boolean visited[] = new boolean[arr.length + 1];
        HashMap<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
        
        for(int i=1;i<visited.length;i++) {
            pairMap.put(i, arr[i-1]);
        }
        
        int swapCount = 0;
        
        for(int i=1;i<=pairMap.size();i++) {
            
            if(visited[i] == false) {
                visited[i] = true;
                
                if(i == pairMap.get(i))
                    continue;
                else {
                    int temp = pairMap.get(i);
                    int next;
                    while(!visited[temp]) {
                        visited[temp] = true;
                        next = pairMap.get(temp);
                        temp = next;
                        swapCount++;
                    }
                }
            }
        }
        
        return swapCount;
	}
	public static void main(String[] args) {
		System.out.println(minSwaps(new int[] {1, 4, 3, 2}));
	}
}
