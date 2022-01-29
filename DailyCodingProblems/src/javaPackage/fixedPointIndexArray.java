package javaPackage;

public class fixedPointIndexArray {

    static boolean fixedPointIndex(int[] arr)
    {
        if(arr == null)
            return false;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == i)
                return true;
        }

        return false;
    }
    

    public static void main(String[] args)
    {
        int[] arr = new int[]{-6, 0, 2, 40};

        boolean result = fixedPointIndex(arr);
        System.out.println(result);
    }
}
