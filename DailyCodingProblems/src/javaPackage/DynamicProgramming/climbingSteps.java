package javaPackage.DynamicProgramming;

public class climbingSteps {

    public static void main(String[] args)
    {
        //Find the variations to climb to n steps 
        // if you have the option of taking 1 or 2 steps each step

        /* From a BST standpoint there are 2 paths per node
         Start from the bottom up and realize that you
         the bottom is just the fibonacci sequence upwards 
         and that you can use memoization to solve subproblems 
         and quickly return the answer for each sub problem
         also only need to store 2 values, the one step and the 2 step cache
             0
             /\
            1  2
           / \  / \
          2   3 3  4
         / \
        3   4
       / \  / \    
      4   5 5  X
        */

        System.out.println(stepVariations(6));
        System.out.println(stepVariations(3));
        System.out.println(stepVariations(5));
        System.out.println(stepVariations(2));
    }

    public static int stepVariations(int n)
    {
        int one = 1, two = 1;

        //[0, 1, 2, 3, 4, 5, 6]
        for(int i =0; i < n-1; i++)
        {
            int temp = one; // 1, 2, 3, 5, 8
            one = one + two; // 2, 3, 5, 8, 13
            two = temp; // 1, 2, 3, 5, 8
        }

        return one;
    }
}
