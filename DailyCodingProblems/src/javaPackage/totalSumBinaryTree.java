package javaPackage;

public class totalSumBinaryTree{

    public static int recursiveDepthFirst(Node root)
    {
        if (root == null)
            return 0;

        return root.data + recursiveDepthFirst(root.left) + recursiveDepthFirst(root.right);
    }

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

        int sum = recursiveDepthFirst(a);
        System.out.println(sum); // 27
    }   

    /*
            5
           / \
          3   6
         / \   \
        1   4   8
    */
}