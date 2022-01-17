package recursion;

import java.util.ArrayList;
import java.util.List;

public class SortUsingRecursion {
	
	private static void sort(List<Integer> list) {
		int len = list.size();
		if(len == 1)
			return;
		
		int temp = list.remove(len - 1);
		sort(list);
		insert(list, temp);
	}

	private static void insert(List<Integer> list, int temp) {
		int len = list.size();
		if(len == 0 || list.get(len - 1) <= temp) {
			list.add(temp);
			return;
		}
		
		int temp1 = list.remove(len - 1);
		insert(list, temp);
		list.add(temp1);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(5);
		list.add(2);
		
		sort(list);
		for(int i:list)
			System.out.println(i);
	}

}
