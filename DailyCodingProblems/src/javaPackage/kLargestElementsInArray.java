package javaPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kLargestElementsInArray {
    
    public static int[] kLargest(int[] arr, int k)
    {
        if(arr == null)
            return null;

        int min = Integer.MAX_VALUE;
        int min_index = 0;

        int[] temp_arr = new int[k];
        for(int i =0; i < k; i++)
        {
            temp_arr[i] = arr[i];

            if(temp_arr[i] < min)
            {
                min = temp_arr[i];
                min_index = i;
            }
            
        }

        // temp_arr = 1, 23, 12
        // min = 1
        // arr = 1, 23, 12, 9, 30, 2, 50

        // O(n-k)
        for(int i = k; i < arr.length; i++)
        {
            // FIRST PASS
            // 9 > 1 .. 
            // temp_arr = 9, 23, 12, min = 9 

            // SECOND PASS
            // 30 > 9 .. 
            // temp_arr = 30, 23, 12, min = 12 

            // THIRD PASS
            // 12 < 2 .. 
            
            // FOURTH PASS 
            // 50 > 12
            // temp_arr = 30, 23, 50

            if(arr[i] > min)
            {
                min = arr[i];
                temp_arr[min_index] = arr[i];

                // O(k)
                for(int j = 0; j < k; j++)
                {
                    if(temp_arr[j] < min)
                    {
                        min = temp_arr[j];
                        min_index = j;
                    }
                }
            }
        }

        return temp_arr;
    }

    // Takes in a Integer[] and uses Arrays.sort method to reverseOrder()
    // them by largest then just print out the first k elements
    // Has to use a Integer[] not a primitive[]
    public static ArrayList<Integer> kLargest(Integer[] arr, int k)
    {
        if(arr == null)
            return null;

        ArrayList<Integer> result = new ArrayList<Integer>();

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < k; i++)
        {
            result.add(arr[i]);
        }

        return result;
    }

    public static Integer[] intToIntegerArray(int[] arr)
    {
        Integer[] IntegerArray = Arrays.stream(arr).boxed().toArray(Integer[] :: new);

        return IntegerArray;
    }

    // TIME COMPLEXITY: O(n-k)*k)
    public static void main(String[] args)
    {
        int[] prim_array = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        int[] result = kLargest(prim_array, k);

        for(int i =0; i < k; i++)
            System.out.println(result[i]);

        Integer[] array = {1, 23, 12, 9, 30, 2, 50};
        ArrayList<Integer> resultList = kLargest(array, k);
        System.out.println(resultList);

        Integer[] newIntegerArray = intToIntegerArray(prim_array);
        ArrayList<Integer> resultList2 = kLargest(newIntegerArray, k);
        System.out.println(resultList2);
    }
}
