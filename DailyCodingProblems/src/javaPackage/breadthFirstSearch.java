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

    public static boolean searchBreadthFirst(Node root, int val)
    {
        if (root == null)
            return false;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node curr = q.remove();

            if(curr.data == val)
                return true;

            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }

        return false;
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

        boolean searchResult = searchBreadthFirst(a, 8);
        System.out.println("8 is in tree: " + searchResult);
        
        boolean searchResult2 = searchBreadthFirst(a, 17);
        System.out.println("17 is in tree: " + searchResult2);
    }

    /*
            5
           / \
          3   6
         / \   \
        1   4   8
    */
}
