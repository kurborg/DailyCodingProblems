package searchesAndSorts;

import java.util.Arrays;

// Sorts numbers in the order of their least significant bit to their most significant bit
// ie. 1s place, 10s place, 100s place

// Time complexity is O(d * (n+b) where n is the num of elements and b is the base in decimal it's 10. d is the number of digits 
// in the max number. Space complexity is O(n+b)

class radixSort{
	
	public static void main(String[] args) {
		int arr[] = {160, 35, 85, 90, 508, 23, 39, 18, 4};
		
		radixSort solution = new radixSort();
		
		int n = arr.length;
		int result[] = solution.radix(arr, n);
		solution.printIntArray(result, n);

	}
	
	public int[] radix(int[] arr, int n)
	{
		//First get the largest value in the array
		int max = arr[0];
		
		for(int i = 1; i < n; i++)
		{
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(int placeValue = 1; max/placeValue > 0; placeValue *= 10)
			countSort(arr, n, placeValue);
		
		return arr;
	}
	
	public void countSort(int arr[], int n, int placeValue)
	{
		int output[] = new int[n];
		int i; 
		//decimal system, numbers 0-9
		int range = 10;
		int frequency[] = new int[10];
		Arrays.fill(frequency, 0);
		
		//place value = 1
		// arr[] = {160, 35, 85, 90, 508, 23, 39, 18, 4}
		// frequency[] = {0, 2, 2, 2, 3, 4, 5, 6, 6, 7}
		// output[] = { 160, 90, 23, 4, 35, 85, 508, 18, 39}
		
		//place value = 10
		// arr[] = {160, 35, 85, 90, 508, 23, 39, 18, 4}
		// frequency[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		// output[] = 4, 508, 18, 23, 35, 39, 160, 85, 90
		
		//place value = 100
		// arr[] = {160, 35, 85, 90, 508, 23, 39, 18, 4}
		// frequency[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		// output[] = 4, 18, 23, 35, 39, 85, 90, 160, 508
		
		// Store count of occurrences of each digit in frequency[]
		for(i = 0; i < n; i++)
		{
			int digit = (arr[i]/ placeValue) % range;
			frequency[digit]++;
		}
		
		// Change frequency[i] so that frequency[i] now contains
		// actual position of this digit in output[]
		// Goes through and basically says okay if you have a 3 or frequency[digit == 3]
		// then you'll be going in place output[frequency[3] - 1], goes down the list
		// keeping track of where each number should go based on the frequency of the digit
		for(i = 1; i < range ; i++)
			frequency[i] += frequency[i-1];
		
		// Build output array
		for(i = n-1; i >=0; i--)
		{
			int digit = (arr[i] / placeValue) % range;
			output[frequency[digit] - 1] = arr[i];
			frequency[digit]--;
		}
		
		//Copy output array to arr[] so that arr[] now 
		// contains sorted numbers according to current digit
		for(i = 0; i<n; i++)
			arr[i] = output[i];
		
		System.out.print("Sorted Array after pass " + placeValue + ":");
		printIntArray(arr, n);

	}
	
	public static void printIntArray(int[] array, int length)
	{
		System.out.print("Sorted Array:");
		for(int i=0; i <length-1; i++)
		{
			System.out.print(" "+ array[i]+",");
		}
		
		System.out.print(" " + array[length-1] + "\n\n");
		
	}
	
	
	
	
	
}