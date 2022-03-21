package javaPackage;

public class expressionTree {
    
    public static class stringNode{
        String data;
        stringNode left;
        stringNode right;

        stringNode(String data_)
        {
            data = data_;   
            left = null;
            right = null;
        }
    }

    static int toInt(String s)
    {
        int result = 0;

        if(s.charAt(0) != '-')
        {
            for(int i = 0; i < s.length(); i++)
            {
                result = result * 10 + ((int)s.charAt(i) - 48);
            }
        }
        else
        {
            for(int i = 0; i < s.length(); i++)
            {
                result = result * 10 + ((int)s.charAt(i) - 48);
            }
            result = result * -1 ;
        }

        return result;
    }

    static int evalRoot(stringNode root)
    {
        if(root == null)
            return 0;

        // 2 options either its a operand (has 2 children) or it's
        // a number (has 0 children).. if number then return int value
        // call recursively the evalRoot function that either returns the int value
        // or returns the operand value of the proper operand + the 2 children node int values
        if(root.left == null && root.right == null)
        {
            return toInt(root.data);
        }

        int leftVal = evalRoot(root.left);
        int rightVal = evalRoot(root.right);

        if(root.data == "+")
            return leftVal + rightVal;
        if(root.data == "*")
            return leftVal * rightVal;
        if(root.data == "-")
            return leftVal - rightVal;
        else 
            return leftVal / rightVal;  
    }
    public static void main(String[] args)
    {
        stringNode root = new stringNode("+");

        stringNode l1 = new stringNode("*");
        stringNode l2 = new stringNode("5");
        stringNode lr2 = new stringNode("4");

        stringNode r1 = new stringNode("-");
        stringNode rl2 = new stringNode("100");
        stringNode r2 = new stringNode("20");

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = lr2;

        r1.left = rl2;
        r1.right = r2;

        System.out.println("Result is : " + evalRoot(root));
    }   
}
