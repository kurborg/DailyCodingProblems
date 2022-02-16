package javaPackage;

public class twoSumSorted {

    public static int[] twoSumSortedFunc(int[] arr, int target)
    {
        int l = 0;
        int r = arr.length - 1;

        while(l < r)
        {
            if(arr[l] + arr[r] < target)
                l++;
            else if (arr[l] + arr[r] > target)
                r--;
            else 
                return new int[] {l, r};
        }

        return null;
    }
    
    public static void main(String[] arg)
    {
        int[] givenArray = new int[] {0, 2, 3, 5, 7, 9};
        int target = 8;

        // Takes a sorted array and returns the indices of the numbers
        // that add up to the target value using shifting window solution
        // Time Complexity O(n)
        int[] result = twoSumSortedFunc(givenArray, target);

        for(int i : result)
        {
            System.out.print(i + " ");
        }
    }
}
