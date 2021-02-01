package searchesAndSorts;

import searchesAndSorts.radixSort;

// Code Problem
// merge a array B into an already sorted array A while knowing A has the allocated space for both arrays
class sortedMerge
{
	public static void main(String[] args)
	{
		
		int[] arrA = {3, 5, 7, 8, 13, 27};
		int[] arrB = {4, 6, 9, 15, 19, 21};
		int[] outputArr = new int[arrA.length + arrB.length];
		sortedMerge solution = new sortedMerge();
		
		solution.merge(outputArr, arrA, arrB, arrA.length, arrB.length);
		radixSort.printIntArray(outputArr, outputArr.length);
		
	}
	
	void merge(int[] output, int[] a, int[] b, int lastA, int lastB) 
	{
		int indexA = 0;
		int indexB = 0;
		int indexMerged = 0;
		
		// BUG TO-DO: Stops merging if either array reaches the end of it's index.
		// Therefore doesn't always sort the last number in one of the arrays
		// merge A and B starting from first element
		while(indexA < lastA && indexB < lastB)
		{
			// index of A < index of B
			if(a[indexA] < b[indexB]) {
				output[indexMerged++] = a[indexA++];
			}
			else { // index of B < index of A
				output[indexMerged++] = b[indexB++];
			}
		}
	}
}