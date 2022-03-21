package javaPackage;

import java.util.Comparator;
import java.util.PriorityQueue;

public class medianStreamInts {
    
    // have 2 heaps, one max left and one min right
    // when adding a new number we must add it to the min then we poll
    // to remove the smallest number and add it to the left max heap
    // then if the right min is smaller we poll from left max 
    // that way if the number of elements is odd we just poll from the bigger
    // right min heap otherwise if the elements are odd we poll the top of 
    // both heaps and get the average of the 2
    static class MedianFinder
    {
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        MedianFinder(){};
        
        public void addNum(int num)
        {
            min.add(num);
            max.add(min.poll());

            // make min larger so we pull median from min heap if odd
            if(min.size() < max.size())
            {
                min.add(max.poll());
            }
        }

        public double findMedian()
        {
            if(min.size() == max.size())
            {
                return (min.peek() + max.peek()) / 2.0;
            }   
            else
                return min.peek();  
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 7, 4, 13, 3, 8, 19, 3};
        MedianFinder medF = new MedianFinder();
        for(int i : nums)
        {
            medF.addNum(i);
            System.out.println("Median at position " + i + ": " + medF.findMedian());
        }
        
    }
}
