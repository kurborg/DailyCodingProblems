package javaPackage;

import java.util.Arrays;

public class radixSort {
    
    // sort by the placement of each digits, starting from
    // 1's position and going up to max digit position
    // Time Comnplexity O(n) faster than quick sort, heap sort, merge sort O(nlog n)
    static void radixSorts(int[] arr)
    {
        // must know max number to know # of digits
        int max = getMax(arr);

        for(int exp = 1; max / exp > 0; exp *= 10)
        {
            countSort(arr, arr.length, exp);
        }
    }

    static void countSort(int[] arr, int len, int exp)
    {
        int[] output = new int[len];
        int i;
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // stores the count of the digit place starting from the 1's position
        for(i = 0; i < len; i++)
            count[(arr[i]/exp) % 10]++; 

        // store the count at the actual position in the array
        for(i = 1; i < 10; i++)
            count[i] += count[i-1];

        // Build the output array by 
        for(i = len - 1; i >= 0; i--)
        {
            output[count[(arr[i]/exp) % 10] - 1] = arr[i];
            count[(arr[i]/exp) % 10]--;
        }

        for(i = 0; i < len; i++)
            arr[i] = output[i];
    }

    static int getMax(int[] arr)
    {
        int max = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] arr = {175, 45, 75, 90, 802, 24, 2, 66};

        radixSorts(arr);
        
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
