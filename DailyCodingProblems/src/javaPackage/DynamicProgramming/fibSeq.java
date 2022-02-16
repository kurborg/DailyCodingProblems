package javaPackage.DynamicProgramming;

import java.util.HashMap;

public class fibSeq {

    public static int fibRecursive(int n, HashMap<Integer,Integer> map)
    {
        if (n <= 2)
        {
            return n;
        }

        if(map.containsKey(n))
        {
            return map.get(n); 
        }
        else
        {
            int result = fibRecursive(n - 1, map) + fibRecursive(n - 2, map);
            map.put(n, result);
            return result;
        }
    }
   
    public static void main(String[] args)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int result = fibRecursive(8, hm);
        System.out.println(result); // 8 7 6 5 4 3 2 1 = 36

        hm.clear();

        result = fibRecursive(3, hm);
        System.out.println(result); // 3 2 1 = 6

        hm.clear();

        result = fibRecursive(5, hm);
        System.out.println(result); // 5 4 3 2 1 = 15
    }
}
