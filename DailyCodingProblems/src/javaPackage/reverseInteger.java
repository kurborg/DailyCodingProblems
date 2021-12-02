package javaPackage;

public class reverseInteger{
	
	public static void main(String[] args) {
		
		reverseInteger solution = new reverseInteger();
		
		System.out.println("Answer 1: " + solution.reverse(456));
		System.out.println("Answer 2: " + solution.reverse(2147483646));
		System.out.println("Answer 3: " + solution.reverse(-2147483647));

	}
	
	public int reverse(int x)
	{
		int rev = 0;
		
		while(x!=0)
		{
			//pop operation
			int pop = x %10; // This gets the digit in each decimal place
			x /= 10;
			
			// to prevent overflow
			if(pop > 0 && rev > (Integer.MAX_VALUE - pop)/10)
				return 0;
			if(pop < 0 && rev < (Integer.MIN_VALUE - pop)/10)
				return 0;
			
			//push operation
			rev = rev * 10 + pop;
		}
		
		
		
		return rev;
	}
	
}