package searchesAndSorts;

// In quick sort we pick a random element and partition the array, such that all numbers that are less than the partitioning elemtn come before all elements that are greater than it. The partitioning 
// can be performed efficiently through a series of swaps.

// If we reportedly partition the array (and its sub-arrays) around an element, the array will eventually become sorted. However, as the partitioned element is not guaranteed to the media (or anywhere
// near the median), our sorting could be very slow. This is the reason for the O(n^2) worst case runtime.

// Average: O(n log(n)) Memory O(log(n))
public class quickSort {
	public static void main(String[] args) {
		
		int[] arr= {4, 5, 1, 6, 7, 8, 12, 64, 53};
		quickSort answer = new quickSort();
		answer.quickSorted(arr, 0, arr.length -1);
		System.out.print("Sorted Array: (");
		for(int i = 0; i < arr.length; i++)
		{
			if( i == arr.length - 1) {
				System.out.print(arr[i] + ")");
				break;
			}
			System.out.print(arr[i] + ", ");
		}
	}
	
	void quickSorted(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if(left < index -1) { // Sort left half
			quickSorted(arr, left, index -1);
		}
		if(index  < right) { //Sort right half 
			quickSorted(arr, index, right);
		}
	}
	
	int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2]; // pick pivot point
		
		while(left <= right) {
			// Find element on left that should be on right
			while(arr[left] < pivot) 
				left++;
			
			// Find element on right that should be on left
			while(arr[right] > pivot)
				right--;
			
			// Swaps elements and move left and right indices
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
		}
	}
		
		return left;
	}
	
	public static void swap(int[] arr, int i, int j) {
	   int temp = arr[i];
	   arr[i] = arr[j];
	   arr[j] = temp;
	}
}