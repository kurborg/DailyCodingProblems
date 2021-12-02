package javaPackage;

public class invertBinaryTree 
{
    /*
            1
           /  \
          2     3
         / \   /  \
        4   5 6    7
       / \
      8   9

      INVERTED:
            1
           /  \
          3     2
         / \   /  \
        7   6 5    4
                   / \
                  9   8
        */ 
    public static class BinaryTree
    {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        BinaryTree(int value_, BinaryTree left_, BinaryTree right_)
        {
            value = value_;
            left = left_;
            right = right_;
        }
    }

    public static BinaryTree reverseBTree(BinaryTree head)
    {
        if(head.left != null)
        {
            reverseBTree(head.left);
            reverseBTree(head.right);
        }

        BinaryTree temp_node;
        temp_node = head.left;
        head.left = head.right;
        head.right = temp_node;


        return head;
    }

    public static void printTree(BinaryTree head)
    {
        if(head == null)
            return;
        
        
        printTree(head.left);
        System.out.print(head.value + " ");
        printTree(head.right);
    }
    //output normal: 8 4 9 2 5 1 6 3 7 
    //output reverse test: 7 3 6 1 5 2 9 4 8 

    public static void main(String[] args)
    {
        BinaryTree head = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4, new BinaryTree(8, null, null), new BinaryTree(9, null, null)), 
        new BinaryTree(5, null, null)), new BinaryTree(3, new BinaryTree(6, null, null), new BinaryTree(7, null, null)));

        printTree(head);

        BinaryTree reversed = reverseBTree(head);
        System.out.println("\nREVERSED: ");
        printTree(reversed);
    }
}
