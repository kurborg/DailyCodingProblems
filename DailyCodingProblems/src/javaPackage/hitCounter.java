package javaPackage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class hitCounter {
    
    static Vector<Integer> hits = new Vector<Integer>();


    /* Brute force method involves using a vector then
        adding values with the timestamp as a value
        then only getting the hits for the timestamp - 300 (last 5 min)
        Time Complexity O(N)
    */

    public static void bruteForceHit(int timeStamp)
    {
        hits.add(timeStamp);
    }

    public static int bruteForceGetHits(int timestamp)
    {
        int i;
        for (i = 0; i < hits.size(); i++)
        {
            if(hits.elementAt(i) > timestamp -300)
                break;
        }

        return hits.size() - i;
    }

    /*
        Queue to store the hits and delete entries in queue that are not in 
        the past 5 minutes. It saves more space. 
        Time Complexity O(N)
    */

    static Queue<Integer> hitQ = new LinkedList<Integer>();
    
    public static void queueHit(int timestamp)
    {
        hitQ.add(timestamp);
    }

    public static int queueGetHits(int timestamp)
    {
        int hits = 0;

        while(!hitQ.isEmpty() && timestamp - hitQ.peek() >= 300)
        {
            hitQ.poll();
        }

        return hits;
    }

    /*
        Most optimized solution is using 2 arrays one for hits and one for TimeStamp
        since we don't know if the hits will be coming in unordered, this accounts for that
        also if they're are multiple hits for one timestamp this also accounts for that
    */

    static int[] optHits = new int[300];
    static int[] times = new int[300];

    public static void optHit(int timestamp)
    {
        int i = timestamp % 300;
        if(times[i] != timestamp)
        {
            times[i] = timestamp;
            optHits[i] = 1;
        }
        else
        {
            optHits[i]++;
        }
    }

    public static int optGetHits(int timestamp)
    {   
        int hits = 0;

        for(int i = 0; i < 300; i++)
        {
            if(optHits[i] > 0)
                hits += optHits[i];
        }

        return hits;
    }

    public static void main(String[] args)
    {

    }
}
