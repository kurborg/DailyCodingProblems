package java;

/*Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed point in the array
 *If there is any Fixed point present in array, else returns -1. Fixed point in an array is an index i such that arr[i] is equal
 *to i. Note that integers in array can be negative.
 *Ex.
 *	input: arr[] = {-10, -5, 0, 3, 7}
 *	output: 3 //arr[3] == 3
 *
 *	input: arr[] = {0, 2, 5, 8, 17}
 *	output: 0 //arr[0] == 0
 */

//Method 1 Linear search
class findFixedPointInGivenArray
{
	static int linearSearch(int arr[], int n)
	{
		int i;
		for (i = 0; i < n; i++)
		{
			if (arr[i] == i)
				return i;	
		}
		
		return -1;
	}
	
//Method 2 Binary search
	static int binarySearch(int arr[], int low, int high)
	{
		if(high >= low)
		{
			int mid = (low + high)/2; //low + (high - low) /2
			if (mid == arr[mid])
					return mid;
			if (mid > arr[mid])
				return binarySearch(arr, (mid +1), high);
			else
				return binarySearch(arr, low, (mid - 1));
		}
		
		return -1;
	}
	
	public static void main(String args[])
	{
		int arr[] = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
		int n = arr.length;
		System.out.println("Fixed point is using linear search is " + linearSearch(arr,n));
		System.out.println("Fixed point is using binary search is " + binarySearch(arr, 0, n-1));
		
		
	}
}
