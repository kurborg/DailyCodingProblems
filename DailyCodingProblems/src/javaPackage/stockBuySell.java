package javaPackage;

import java.util.ArrayList;
import java.util.List;

public class stockBuySell {
    

    // Go through array and if the next value is greater then lock in profits
    // return all the profits from each buy/sell peak/valley
    static int bruteForce(int[] prices)
    {
        int maxProfit = 0;

        for(int i = 0; i < prices.length - 1; i++)
        {
            if(prices[i+1] > prices[i])
            {
                maxProfit += prices[i+1] - prices[i];
            }
        }

        return maxProfit;
    }

    static class Interval
    {
        int buy, sell;
    }

    // Here we can buy/sell on multiple days
    // we want to find the maximum profit secured through the price lifecycle
    // therefore we find the local min and max and compare the greatest difference between
    // them without overlapping periods
    static void multipleMaxSellPeriod(int[] prices)
    {
        int n = prices.length;

        if(n == 1)
            return;

        int count = 0;

        List<Interval> result = new ArrayList<Interval>();

        int i = 0;
        while(i < n - 1)
        {
            // Find local min
            // if the next value is smaller.. keep moving local min right
            while(i < n - 1 && prices[i+1] <= prices[i])
                i++;
            
            Interval interval = new Interval();
            interval.buy = i++;

            // Find local max
            // if the next value is greater.. keep moving local max right
            while(i < n - 1 && prices[i+1] >= prices[i])
                i++;

            interval.sell = i++;

            result.add(interval);
            count++;
        }

        if(count == 0)
        {
            System.out.println("No profitable buy/sell interval was found.");
        }
        else
        {
            for(int j = 0; j < count; j++)
            {
                System.out.println("Profitable buy/sell interval " + j + ": Buy on Day " + result.get(j).buy + 
                    " and sell on Day " + result.get(j).sell);
            }
        }

        return;
    }

    public static void main(String[] args)
    {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

        System.out.println(bruteForce(prices));

        multipleMaxSellPeriod(prices);
    }
}
