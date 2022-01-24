package javaPackage;

public class binaryTreeMaxPathSum {
    

    public static int findMaxPathSum(Node root)
    {
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.left == null && root.right == null)
            return root.data;
        return root.data + Math.max(findMaxPathSum(root.left), findMaxPathSum(root.right));
    }

        /*
            5
           / \
          3   6
         / \   \
        1   4   8
    */
    public static void main(String[] args)
    {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(6);
        Node d = new Node(1);
        Node e = new Node(4);
        Node f = new Node(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
    
        int result = findMaxPathSum(a); // 5 3 1 4 6 8

        System.out.println(result); // 5 3 1 4 6 8
    }   


}
