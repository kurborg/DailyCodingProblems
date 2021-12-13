package javaPackage;

public class trailingZeroes {
    

    public static int trailingZeroesinFactorial(int n)
    {
        // Trick is to notice that there is only a trailing zero 
        // when the number contains pairs of 5 and 2's in its factorial
        // ie. 5! = 5 * 4 * 3 * 2 * 1 = 120.. 5 * 2^3 is 1 trailing zero
        // ie. 11! = 11 * 10 (5*2) * 9 * 8 (2*2*2) * 7 * 6 (3*2) 
        // * 5 * 4 (2*2) * 3 * 2 * 1 = 2^8 * 3^4 * 5^2 * 7 = 2 pairs so 2 
        // trailing 0's

        //2 always has more prime factors so we simply divide by 5 to find 
        // the # of factors of 5.. then for larger numbers we have to take 
        // into account 25 (5*5) is a double factor and so on... thereby 
        // we increase our loop incremental by a factor of 5 for this
        int zeros = 0;

        if(n < 0 )
            return -1;
        
        for(int i = 5; n / i >= 1; i *= 5)
        {
            zeros += n/i;
        }

        return zeros;
    }

    public static void main(String[] args)
    {
        // Assertions only work when enabled...
        // run java -ea trailingZeroes to execute with Assertions
        System.out.println("Trailing zeroes in 5! : " +  trailingZeroesinFactorial(5));
        assert trailingZeroesinFactorial(5) == 1 : "Fail";
        
        System.out.println("Trailing zeroes in 100! : " +  trailingZeroesinFactorial(100));
        assert trailingZeroesinFactorial(100) == 24 : "Fail";

    }
}
