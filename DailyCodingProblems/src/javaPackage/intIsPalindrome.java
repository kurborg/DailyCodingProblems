package javaPackage;

public class intIsPalindrome {

    public static void main(String[] args)
    {
        int x = 1234321;
        int y = 456789;
        int z = 987654321;
        int k = 98766789;
        intIsPalindrome solution = new intIsPalindrome();

        System.out.println("Num 1: " + solution.checkIntForPalindrome(x));
        System.out.println("Num 2: " + solution.checkIntForPalindrome(y));
        System.out.println("Num 3: " + solution.checkIntForPalindrome(z));
        System.out.println("Num 4: " + solution.checkIntForPalindrome(k));

    }
    
    private boolean checkIntForPalindrome(int x)
    {
        if(x < 0 || x %10 == 0 && x != 0)
            return false;

        int size = String.valueOf(x).length();

        int reverseNum = 0;
        //Logic is if we split the number in half (ie. while the original num is less than the reverse num)
        //if the reversed second half of the number is equal to the first half then it's a palindrome.
        //we get the digit in the singles place each loop and then shift the original number left in 
        //each loop. 
        while(x > reverseNum)
        {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        // Since we go until the reverseNum is larger, if the size of the 
        // original num was odd then we cut off the last digit of the
        // reverseNum to check for equivalency.
        if(size % 2 == 0)
            return x == reverseNum;
        else
            return x == reverseNum/10;
    }
}
