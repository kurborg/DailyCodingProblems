package javaPackage;

public class missingNumberInArray {
    

    public static int findMissingNumber(int[] n, int l)
    {
        int sum = (l*(l+1))/2;
        for(int i = 0; i < l - 1; i++)
        {
            sum = sum - n[i];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 4, 5};
        int missingNum = findMissingNumber(nums, nums.length);
        System.out.println(missingNum);

        int[] nums2 = {6, 7, 3 ,2 ,1 ,5, 8, 9};
        missingNum = findMissingNumber(nums2, nums2.length);
        System.out.println(missingNum);
    }
}
