package javaPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class breadthFirstSearch {
    
    public static ArrayList<String> breadthFirstValues(Node root)
    {
        if (root == null)
            return null;

        ArrayList<String> result = new ArrayList<String>();

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node curr = q.remove();
            result.add(Integer.toString(curr.data));

            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }

        return result;
        
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

        ArrayList<String> result = breadthFirstValues(a);
        System.out.println(result);
    }

    /*
            5
           / \
          3   6
         / \   \
        1   4   8
    */
}
