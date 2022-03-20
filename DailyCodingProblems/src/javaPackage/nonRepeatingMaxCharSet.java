package javaPackage;

import java.util.HashSet;

public class nonRepeatingMaxCharSet {
    
    static int maxUniqueChars(String words)
    {
        HashSet<Character> chars = new HashSet<Character>();
        int l = 0;
        int r = 0;
        int len = words.length();
        int maxLen = 0;

        while(r < len)
        {
            if(chars.contains(words.charAt(r)))
            {
                chars.remove(words.charAt(l));
                l++;
            }
            else
            {
                chars.add(words.charAt(l));
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }

        return maxLen;
    }

    public static void main (String[] args)
    {
        String word = "abcabcabcdeabc";

        System.out.println(maxUniqueChars(word));
    }
}
