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
        int currentStep = 0;
        int previousStep = 1;
        int totalSteps = 0;

        //[0, 1, 2, 3, 4, 5, 6]
        // loop: 5..0,  6 loops
        for(int i = n -1; i >=0 ; i--)
        {
            totalSteps = currentStep + previousStep; // 1, 2, 3, 5, 8, 13
            currentStep = previousStep; // 1, 1, 2, 3, 5, 8
            previousStep = totalSteps; // 1, 2, 3, 5, 8, 13
        }

        return totalSteps;
    }
}
