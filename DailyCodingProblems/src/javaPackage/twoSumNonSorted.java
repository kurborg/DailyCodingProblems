package javaPackage;

import java.util.HashMap;

public class twoSumNonSorted {

    public static int[] twoSumNonSortedFunc(int[] arr, int target)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int diff; 

        for(int i = 0; i < arr.length; i++)
        {
            hm.put(arr[i], i);
        }

        for(int i = 0; i< arr.length; i++)
        {
            diff = target - arr[i];

            if(hm.containsKey(diff) && hm.get(diff) != i)
            {
                return new int[]{i, hm.get(diff)};
            }
        }

        return null;

    }
   
    public static void main(String[] args)
    {
        int[] givenArr = new int[]{2, 1, 6, 9, 5, 32, 8};
        int target = 11;

        int[] result = twoSumNonSortedFunc(givenArr, target);

        for(int i : result)
            System.out.print(i + " ");
    }
}
