package javaPackage;

import java.util.HashMap;
import java.util.Map;

public class twoSumOnePass {

    static int[] twoSumFunc(int arr[], int targ)
    {
        Map<Integer, Integer> prevMap = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < arr.length; i++)
        {
            int diff = targ - arr[i];

            if(prevMap.containsKey(diff))
            {
                return new int[]{i, prevMap.get(diff)};
            }
            else
            {
                prevMap.put(arr[i], i);
            }
        }

        return null;
    }
    

    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 3, 5, 9};
        int target = 4;

        int[] result = twoSumFunc(arr, target);

        for(int i = 0; i < 2; i++)
        {
            System.out.println(result[i]);
        }
    }
}
