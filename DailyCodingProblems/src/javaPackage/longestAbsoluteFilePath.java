package javaPackage;

import java.util.Stack;

public class longestAbsoluteFilePath {
    

    public static int findLongestFilePath(String n)
    {
        int max = 0;

        n.replace("\t", "@");
        n.replace("\n", "#");

        //dir#, @subdir1#, @@file1.ext#, @@subsubdir1#, @subdir2#, @@subsubdir2#, @@@file2.ext
        
        Stack<Integer> stack = new Stack<>();

        String[] str = n.split("#");

        for(String S : str)
        {
            // popping from stack till we have the same size as the level: 0, 1, 2, 2, 1, 2, 3
            int l = S.lastIndexOf('@') + 1;
            while(l < stack.size() && !stack.isEmpty())
            {
                stack.pop();
            }

            //if the path contains a file, we compare it to the max and the level it's on
            if(S.contains("."))
            {
                max = Math.max(max, stack.size() > 0 ? (stack.peek() + 1 + S.length() -1 ) : S.length() -1 );
            }
            else
            {
                if(stack.size() == 0)
                    stack.push(S.length());
                else 
                    stack.push(stack.peek() + 1 + S.length() -1);
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        String filePath = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        int GCPL = findLongestFilePath(filePath);

        System.out.println("Greatest File Path Length: " + GCPL);
    }
}
