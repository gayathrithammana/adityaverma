package topKElements.educative;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Time Complexity: O(logN) - for both push and pop 
 * Space Complexity: O(N)
 */
public class FrequencyStack {

	static Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
	static PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
	static int seqNumber = 0;
	
	public void push(int num) {
		freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		maxHeap.offer(new Element(num, freqMap.get(num), seqNumber++));
	}

	public int pop() {
		int num = maxHeap.poll().number;
		
		if(freqMap.get(num) > 1)
			freqMap.put(num, freqMap.get(num) - 1);
		else
			freqMap.remove(num);
		
		return num;
	}

	public static void main(String[] args) {
		FrequencyStack frequencyStack = new FrequencyStack();
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(3);
		frequencyStack.push(2);
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(5);
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
	}
}

class Element {
	int number;
	int frequency;
	int sequenceNumber;

	public Element(int number, int frequency, int sequenceNumber) {
		this.number = number;
		this.frequency = frequency;
		this.sequenceNumber = sequenceNumber;
	}
}
class ElementComparator implements Comparator<Element>{
	public int compare(Element e1, Element e2) {
		if(e1.frequency != e2.frequency)
			return e2.frequency - e1.frequency;
		
		return e2.sequenceNumber - e1.sequenceNumber;
	}
}
