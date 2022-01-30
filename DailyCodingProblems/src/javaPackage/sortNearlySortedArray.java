package javaPackage;

import java.util.Iterator;
import java.util.PriorityQueue;

public class sortNearlySortedArray {
   
    static void insertionSort(int[] arr)
    {
        int i, key, j;
        for(i = 1; i < arr.length; i++)
        {
            key = arr[i];
            j = i -1;

            // go through arr[0..i-1]
            // if arr[j] is greater than i then swap with arr[i]
            // then repeat for all elements before that
            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j -=1;
            }
            
            arr[j+1] = key;
        }

    }

    static void kSortHeap(int[] arr, int k)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        //add first k elements to the min heap
        // O(k) time complexity
        for(int i = 0; i < k +1; i++)
        {
            queue.add(arr[i]);
        }

        int index = 0; 

        // queue is sorted by min, so each poll will remove the smallest int
        // from the arr and add it back into the array from the beginning at index
        // then add the next element from k+1 to the queue for next pass
        // O(n-k) time complexity
        // Plus removing from and adding new element to min heap takes log(k) time
        for(int i = k+1; i < arr.length; i++)
        {
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }

        Iterator<Integer> itr = queue.iterator();

        // for the remaining elements in the queue add them to the index
        // in the sorted order 
        while(itr.hasNext())
        {
            arr[index++] = queue.poll();
        }

        //Overall time complexity for min heap is
        // O(k) + O(n-k) + O(log k)
    }

    static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i ++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};

        System.out.println("Before Insertion sort: ");
        printArray(arr);

        insertionSort(arr);

        System.out.println("\nAfter Insertion sort: ");
        printArray(arr);

        System.out.println("\nArray 2: Before Insertion sort: ");
        printArray(arr2);

        kSortHeap(arr2, 4);

        System.out.println("\nArray 2: After Insertion sort: ");
        printArray(arr2);
    }
}
