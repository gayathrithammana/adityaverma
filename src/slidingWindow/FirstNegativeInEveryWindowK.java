package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * First Negative Number in every Window of Size K | Sliding Window
 * @author Gaya 3
 */

public class FirstNegativeInEveryWindowK {
	public static List<Integer> findFirstNegative(int[] arr, int k) {
		int i = 0;
		int j = 0;
		List<Integer> tempList = new ArrayList<>();
		List<Integer> finalList = new ArrayList<>();
		while (j < arr.length) {
			
			if(arr[j] < 0)
				tempList.add(arr[j]);
			
			if (j - i + 1 < k) 
				j++;
			else if (j - i + 1 == k) {
				if(tempList.size() == 0)	//when all are +ve in window we didnt add to tempList, hence return 0
					finalList.add(0);
				else {
					int firstElem = tempList.get(0);
					finalList.add(firstElem);
					
					//before sliding revert calculations of i
					//if arr[i] is first elem in list, then remove from temp list before sliding
					if(arr[i] == tempList.get(0))	
						tempList.remove(0);
				}
				
				//slide window
				i++;
				j++;
			}
		}
		
		return finalList;

	}

	public static void main(String[] args) {
		List<Integer> list = findFirstNegative(new int[] {12, -1, -7, 8, -15, 30, 16, 28}, 3);
		for(int i: list) {
			System.out.println(i);
		}
	}

}
