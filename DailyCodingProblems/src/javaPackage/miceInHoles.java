package javaPackage;

import java.util.ArrayList;
import java.util.Collections;

public class miceInHoles{

    static int findMiceToHoles(ArrayList<Integer> mice, ArrayList<Integer> holes)
    {
        if(mice == null || holes == null)
            return 0;
        if(mice.size() != holes.size())
            return -1;
        
        Collections.sort(mice);
        Collections.sort(holes);

        int maxDiff = 0;

        for(int i = 0; i < mice.size(); i++)
        {
            int temp = Math.abs(mice.get(i) - holes.get(i));
            maxDiff = Math.max(maxDiff, temp);
        }

        return maxDiff;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> mice = new ArrayList<Integer>();
        mice.add(4);
        mice.add(-4);
        mice.add(2);
        ArrayList<Integer> holes= new ArrayList<Integer>();
        holes.add(4);
        holes.add(0);
        holes.add(5);
        System.out.println("The last mouse gets into "+
         "the hole in time: "+ findMiceToHoles(mice, holes));
    }
}