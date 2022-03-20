package javaPackage;

public class houseRobber {
    
    //for decision tree the subproblem is repeating, either rob 1 or rob 2
    // go through houses and set rob1 shifting to rob2 every time 
    // and set rob2 equal to the max each run
    // at the end of the array, rob2 will hold the max for robbed houses
    static int determineHouseOrder(int[] houses)
    {
        int rob1 = 0;
        int rob2 = 0;

        for(int i : houses)
        {
            int temp;
            temp = Math.max(rob1 + i, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static void main(String[] args)
    {
        int[] houses = {1, 2, 3, 1, 2, 7};
        System.out.println(determineHouseOrder(houses));
    }
}
