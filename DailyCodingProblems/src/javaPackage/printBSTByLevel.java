package javaPackage;

import java.util.LinkedList;

class printBSTByLevel{


    static void printByLevel(Node root)
    {
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int len = queue.size();

            while(len > 0)
            {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                len--;
            }
            System.out.println("");
        }
    }
    public static void main(String[] args)
    {
        /*
                1
               / \
              2   3
                 / \
                4   5
                   /
                  6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);

        printByLevel(root);
    }
}