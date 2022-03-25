package javaPackage;

public class jumpGame2 {
    
    static int minJumps(int[] arr)
    {
        int r = 0;
        int l = 0;
        int res = 0;

        while(r < arr.length - 1)
        {
            int farthest = 0;
            // loop through the range window of L to R to find the largest jump for R
            // position next
            // loop starts at i is equal to left window range
            // limit will be r+1 since we want r to be inclusive
            for(int i = l; i < r +1; i++)
            {
                farthest = Math.max(farthest, i + arr[i]);
            }
            // l will be equal to the index adj to R since that's 
            // the next lowest window slot
            l = r + 1;
            // r will be equal to the farthest possible jump 
            r = farthest;
            // increment result by 1 since it's taking +1 extra jump turn
            res += 1;
        }

        // after this the r will be equal to the last index so just return result
        // which will be the # of turns to reach the last index
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 3, 1, 1, 4};
        int[] arr2 = {2, 3, 1, 1, 1, 5, 6};

        System.out.println(minJumps(arr));
        System.out.println(minJumps(arr2));
    }
}
