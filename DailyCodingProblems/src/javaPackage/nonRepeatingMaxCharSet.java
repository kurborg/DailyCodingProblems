package javaPackage;

import java.util.HashSet;

public class nonRepeatingMaxCharSet {
    
    // Create a set that will only allow for non-duplicates
    // add to the set if the new char on the right sliding window isn't in the set
    // if it is in the set then remove from set and move left sliding window over
    // at each new char, get max of prev max and current max which is r - l + 1
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
