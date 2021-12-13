package javaPackage;

public class greatestFactorInArray {
    
    // 8, 9 -> 1, 1 -> 0, 1
    public static int gcd(int a, int b)
    {
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int findGCD(int[] nums, int n)
    {   
        int result = 0;

        for(int ele : nums)
        {
            /*
            0, 14 -> 14 .. 14, 7 -> 7, 14 -> 0, 7 -> 7 .. 7, 7 -> 0, 7 -> (7)
            */
            result = gcd(result, ele); 
            
            if(result == 1)
                return result;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {14, 7, 28};
        int gcf = findGCD(nums, nums.length);
        System.out.println(gcf);

        int[] nums2 = {6, 7, 3 ,2 ,1 ,5, 8, 9};
        gcf = findGCD(nums2, nums.length);
        System.out.println(gcf);
    }
}
