import java.util.HashMap;

public class romanNumToInt {

    public static void main(String[] args)
    {
        String one = "III";
        String two = "IV";
        String three = "IX";
        String four = "LVIII";
        String five = "MCMXCIV";

        romanNumToInt solution = new romanNumToInt();
        System.out.println(solution.romanToInt(one));
        System.out.println(solution.romanToInt(two));
        System.out.println(solution.romanToInt(three));
        System.out.println(solution.romanToInt(four));
        System.out.println(solution.romanToInt(five));
    }

    public int romanToInt(String roman)
    {
        if (roman == null)
            return 0;
        
        int length = roman.length();
        int sum = 0;
        int pre = 0;

        for(int i = length -1; i >=0; i--)
        {
            int cur = romanValues(roman.charAt(i));

            if(i == length - 1)
                sum = sum + cur;
            else{
                if(cur < pre)
                    sum = sum - cur;
                else
                    sum = sum + cur;
            }

            pre = cur;
        }

        return sum;
    }

    public int romanValues(char c)
    {
                
        HashMap<Character, Integer> romans = new HashMap<Character, Integer>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        return romans.get(c);
    }
}
