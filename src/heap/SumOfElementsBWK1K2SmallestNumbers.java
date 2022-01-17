package heap;

public class SumOfElementsBWK1K2SmallestNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {1, 3, 12, 5, 15, 11};	//1 3 5 11 12 15 (11+12 = 23)
		int firstK = KthSmallest.kthSmallest(arr, 3);
		int secondK = KthSmallest.kthSmallest(arr, 6);
		
		int sum = 0;
		for(int i : arr) {
			if(i > firstK && i < secondK) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

}
