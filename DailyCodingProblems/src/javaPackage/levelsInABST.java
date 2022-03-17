package javaPackage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class levelsInABST {

    static int maxDepth(Node root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static int breadthSearchMax(Node root)
    {
        int count = 0, result = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
    
        while(!q.isEmpty())
        {
            count = q.size();
            while(count > 0)
            {
                Node curr = q.poll();
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                count--;
            }
            result++;
        }
        return result;
    }
    
    public static void main(String args[])
    {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node (4);
        Node leftRight = new Node(5);
        Node rightLeft = new Node(6);
        Node rightRight = new Node(7);
        Node rightLeftLeft = new Node(8);

        /*
                     1
                    /  \
                   2     3
                  / \    / \
                 4   5   6  7
                         /
                        8

                    */

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = leftRight;

        right1.left = rightLeft;
        right1.right = rightRight;

        rightLeft.left = rightLeftLeft;

        System.out.println("solution 1 Recursion: " + maxDepth(root));

        System.out.println("solution 2 Depth: " + depthSearchMax(root));

        System.out.println("solution 3 Breadth: " + breadthSearchMax(root));
    }
}
