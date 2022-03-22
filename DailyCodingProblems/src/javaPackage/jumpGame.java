package javaPackage;

public class jumpGame {
    
    // See if given an array if it's possible to reach 
    // the end of the array (last index) if you're allowed to
    // jump up to the value of each array's value 
    // ie. [2, 1, 3, 0, 4] return True 2->3->4
    // ie. [1, 0, 2, 3] return False 1->0
    public static boolean reachEnd(int[] arr)
    {
        int goal = arr.length -1; // 4
        for(int i = arr.length-2; i >= 0; i--)
        {
            if(arr[i] + i >= goal)
                goal = i;
        }

        if(goal == 0)
            return true;
        else
            return false;
    }

    public static void printResult(int[] arr)
    {
        System.out.println("Result is: " + reachEnd(arr));
    }

    public static void main(String[] args)
    {
        int[] arr1 = {2, 1, 3, 0, 4};
        int[] arr2 = {1, 0, 2, 3};
        
        printResult(arr1);
        printResult(arr2);
    }
}
