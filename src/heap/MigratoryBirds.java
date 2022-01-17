package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * hackerrank
 * 
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * 
 * solution1 : using freq map and heap
 * solution2 : using arrays
 * @author Gaya 3
 *
 */

public class MigratoryBirds {
	
	//solution1 : using freq map and heap
	static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(Integer num : arr){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }
        
        PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            maxHeap.offer(new Element(entry.getKey(), entry.getValue()));
        }
        return maxHeap.peek().typeId;

    }
	
	//solution2 : using arrays
	static int migratoryBirds1(List<Integer> arr) {
	       int typesOfBirds = 5;
	       int[] count = new int[typesOfBirds];
	       
	       for(int num:arr)
	           count[num-1]++;
	       
	       int max = 0;
	       int maxType = 0;
	       for(int i=0;i<typesOfBirds;i++){
	           if(count[i] > max){
	               max = count[i];
	               maxType = i+1;
	           }
	           
	       }
	       
	       return maxType;

	    }
	
	public static void main(String[] args) {
		System.out.println(migratoryBirds(Arrays.asList(1,4,4,4,2)));
	}

}

class Element{
    int typeId;
    int freq;
    
    Element(int typeId, int freq){
        this.typeId = typeId;
        this.freq = freq;
    }
}

class ElementComparator implements Comparator<Element>{
    public int compare(Element e1, Element e2){
        if(e1.freq != e2.freq)
            return e2.freq - e1.freq;
            
        return e1.typeId - e2.typeId;
    }
}
