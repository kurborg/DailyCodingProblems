package java;

public class longestCommonPrefix {

    public static void main(String[] args)
    {
        String[] words = new String[] {"bobber", "bobby", "bobbest", "bobbenson"};
        String[] words2 = new String[] {"leets", "leetcode", "leet", "leeds"};
        longestCommonPrefix solution = new longestCommonPrefix();
        System.out.println(solution.longestCommPre(words));
        System.out.println(solution.longestCommPre(words2));
    }
    

    public String longestCommPre(String[] strings)
    {
        int j = 0;

        if (strings.length == 0) 
            return "";

        String prefix = strings[0];

        for (int i = 1; i < strings.length; i++)
        {
            //returns 0 if the substring prefix is found in 
            //the next string in the array strings[i]
            //otherwise returns -1. Keeps decreasing by letter
            //for prefix until a pattern is found or its empty
            //then returns ""
            j = strings[i].indexOf(prefix);
            while (j != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                j = strings[i].indexOf(prefix);

                if (prefix.isEmpty()) 
                    return "";
            }        
        }
        return prefix;
    }
}
