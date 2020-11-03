package searchesAndSorts;

//The binary search time complexity is 0(log2n), where we have n data items. 
//For this the maximum comparisons required are 1+log2n and that is what makes 
//binary search far more efficient than a linear search for the most part. 
//However, linear search is more efficient than binary search for shorter arrays.

public class binarySearch{
	public static void main(String args[]) {
		if(args.length != 2) {
			System.err.println("usage: java binarySearch integers integer");
			return;
		}
		
		//Read integers from first command-line argument. Return if integers could 
		// not be read
		int[] ints = readIntegers(args[0]);
		if (ints == null)
			return;
		
		// Read search integer; NumberFormatException is thrown
		// if the integer isn't valid
		int srchInt = Integer.parseInt(args[1]);
		
		// Perform the search and output the result
		System.out.println(srchInt + (search(ints, srchInt) ? " found" : " not found"));
		
	}

		
		private static int[] readIntegers(String s) {
			String[] tokens = s.split(",");
			int[] integers = new int[tokens.length];
			
			for(int i = 0; i <tokens.length; i++)
				integers[i] = Integer.parseInt(tokens[i]);
			
			return integers;
		}
		
		private static boolean search(int[] x , int srchInt) {
			int hiIndex = x.length - 1, loIndex = 0, midIndex;
			
			while(loIndex <= hiIndex) {
				midIndex = (loIndex + hiIndex)/2;
				
				if(srchInt> x[midIndex])
					loIndex = midIndex + 1;
				else if(srchInt < x[midIndex])
					hiIndex = midIndex-1;
				else
					return true;
			}
			
			return false;
		}
}