package javaPackage;

import java.util.Arrays;

public class mergeKSortedArrays {

    static final int n = 4;

    // naive method
    // Time Complexity O(k*n*log(k*n))
    // Space Complxity O(k*n) resulting array is size k*n
    static int[] sortKArrays(int[][] arr, int k, int n)
    {
        int[] result = new int[k*n];
        int index = 0;

        for(int i = 0; i < k; i++)
        {
            for(int j =0; j < n; j++)
            {
                result[index++] = arr[i][j]; 
            }
            
        }

        Arrays.sort(result);

        return result;
    }

    // Time Complexity O(n*k*log k)
    // There are log k levels as in each level the k arrays are divided in half
    // at each level the k arrays are traversed so time complexity for that would be k*n

    // Space Complexity O(n*k*log k)
    // In each level (n*k) sized array is needed..s * log k levels
    static void recursiveMergeKArrays(int[][] arr, int i, int j, int output[])
    {
        // if there's only 1 array just store output array and return
        if(i == j)
        {
            for(int p = 0; p < n; p++)
                output[p] = arr[i][p];
            return;
        }

        // if there's just 2 arrays left then call mergeArrays and store in output then return
        if(j - i == 1)
        {
            mergeArrays(arr[i], arr[j], n, n, output);
            return;
        }

        int output1Size = n*(((i+j)/2) - i + 1);
        int output2Size = n*(j - ((i+j)/2));

        int[] output1 = new int[output1Size];
        int[] output2 = new int[output2Size];

        // split the arrays and call recursive function to further split or return for final merge
        recursiveMergeKArrays(arr, i, (i+j)/2, output1);
        recursiveMergeKArrays(arr, (i+j)/2 + 1, j, output2);

        // call final merge between output arrays 1 and 2 into final output array
        mergeArrays(output1, output2, output1Size, output2Size, output);
    }

    static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] output)
    {
        int i =0, j =0, k =0;

        // Traverse through both arrays
        while( i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
                output[k++] = arr1[i++];
            else  
                output[k++] = arr2[j++];
        }

        // get remaining elements in either arr1 or arr2
        // can't be both since previous conditional ended so one must have more elements
        if(i < n1)
            output[k++] = arr1[i++];
        if(j < n2)
            output[k++] = arr2[j++];
    }

    static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");
    }

    public static void main (String [] args)
    {
        int[][] arr = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int[] result = sortKArrays(arr, 3, 4);

        printArray(result);

        int[][] arr2 = {{2, 6, 12, 34}, {1, 9, 20, 1000}, {23, 34, 90, 2000}};

        // returns number of arrays ie 3
        int len = arr2.length;

        // n is the length of each array which is final 
        // so final output array is size len * n
        int[] output = new int[len * n];

        recursiveMergeKArrays(arr2, 0, len - 1, output);
        printArray(output);
    }
}
