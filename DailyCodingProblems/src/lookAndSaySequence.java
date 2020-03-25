/*
 * Sequence Definition

Take a decimal number
Look at the number, visually grouping consecutive runs of the same digit.
Say the number, from left to right, group by group; as how many of that digit there are - followed by the digit grouped.
This becomes the next number of the sequence.

An example:

Starting with the number 1,   you have one 1 which produces 11
Starting with 11,   you have two 1's.   I.E.:   21
Starting with 21,   you have one 2, then one 1.   I.E.:   (12)(11) which becomes 1211
Starting with 1211,   you have one 1, one 2, then two 1's.   I.E.:   (11)(12)(21) which becomes 111221
 * 
 */

class lookAndSaySequence
{
	public static String lookAndSay(String number)
	{
		StringBuilder result = new StringBuilder();
		
		char repeat = number.charAt(0);
		number = number.substring(1)+ " ";
		int times = 1;
		
		for (char actual: number.toCharArray())
		{
			if(actual != repeat)
			{
				result.append(times+ ""+ repeat);
				times = 1;
				repeat = actual;	
			}
			else
				times += 1;
		}
		
		return result.toString();
	}
	
	public static void main(String[] args)
	{
		String num = "1";
		
		for (int i = 1; i <= 10; i++)
		{
			System.out.println(num);
			num = lookAndSay(num);
		}
	}
	
}