package searchesAndSorts;

// Code Problem
// merge a array B into an already sorted array A while knowing A has the allocated space for both arrays
class sortedMerge
{
	public static void main(String[] args)
	{
		int[] arrA = {3, 5, 7, 8, 13, 27};
		int[] arrB = {4, 6, 9, 15, 19, 21, 29};
		int[] outputArr = new int[arrA.length + arrB.length];
		sortedMerge solution = new sortedMerge();
		
		solution.merge(outputArr, arrA, arrB, arrA.length, arrB.length);
		solution.printIntArray(outputArr, outputArr.length);
		
	}
	
	void merge(int[] output, int[] a, int[] b, int lastA, int lastB) 
	{
		int indexA = 0;
		int indexB = 0;
		int indexMerged = 0;

		
		while(indexA < lastA && indexB < lastB){
			
			// index of A < index of B
			if(a[indexA] < b[indexB]) {
				output[indexMerged++] = a[indexA++];
			}
			else if (b[indexB] < a[indexA]) { // index of B < index of A
				output[indexMerged++] = b[indexB++];
			}
		}

		while (indexA < lastA) {
			output[indexMerged++] = a[indexA++]; 
		}     

		while (indexB < lastB) { 
			output[indexMerged++] = b[indexB++]; 
		}

	}

	private void printIntArray(int[] array, int length)
	{
		System.out.print("Sorted Array:");
		for(int i=0; i <length-1; i++)
		{
			System.out.print(" "+ array[i]+",");
		}
		
		System.out.print(" " + array[length-1] + "\n\n");
		
	}
}