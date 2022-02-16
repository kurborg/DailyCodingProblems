package javaPackage;

import java.util.Stack;

public class matchingBrackets {

    public static boolean checkBrackets(String arr)
    {
        Stack<Character> s = new Stack<Character>();

        char[] charArr =  arr.toCharArray();

        for(char c : charArr)
        {
            if(c == '(' || c == '{' || c == '[')
            {
                s.add(c);
            }
            if(c == ')' && !s.empty())
            {
                char sc = s.pop();
                if(sc != '(')
                {
                    return false;
                }
            }
            if(c == '}' && !s.empty())
            {
                char sc = s.pop();
                if(sc != '{')
                {
                    return false;
                }
            }
            if(c == ']' && !s.empty())
            {
                char sc = s.pop();
                if(sc != '[')
                {
                    return false;
                }
            }
        }

        if(!s.empty())
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        String arr1 = "({[]})";
        String arr2 = "({[]}";
        String arr3 = "(()))({[]})";

        boolean result = checkBrackets(arr1);
        System.out.println(result);
    
        result = checkBrackets(arr2);
        System.out.println(result);

        result = checkBrackets(arr3);
        System.out.println(result);
    }
    
}
