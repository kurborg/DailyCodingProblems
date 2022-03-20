package javaPackage;

import java.util.ArrayList;
import java.util.List;

public class findNumberNotInList {
    
    static Integer findNumbers(List<Integer> arr, int n)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        n = (int) Math.floor(n);
        if (n == 0)
            return arr.contains(0) ? null : 0;

        int i = 0;
        int dir = (int) Math.signum(n);

        while(i != n)
        {
            if (!arr.contains(i))
                result.add(i);
            i+= dir;
        }

        return result.get((int)Math.floor(Math.random()*result.size()));
    }

    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(5);
        int result = findNumbers(arr, 7);

        System.out.println(result);
    }
}
