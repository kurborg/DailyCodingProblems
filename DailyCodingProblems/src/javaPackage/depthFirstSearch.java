package javaPackage;

import java.util.ArrayList;
import java.util.Stack;
import java.util.prefs.NodeChangeListener;

public class depthFirstSearch{

    public static ArrayList<String> depthFirstValues(Node root)
    {
        if (root == null)
            return null;

        ArrayList<String> result = new ArrayList<String>();

        Stack<Node> st = new Stack<Node>();

        st.push(root);

        while(st.size() > 0 )
        {
            Node current = st.pop();
            result.add(Integer.toString(current.data) + " ");

            if(current.right != null)
            {
                st.push(current.right);
            }
            if(current.left != null)
            {
                st.push(current.left);
            }
        }


        return result;
    } 

    public static void recursiveDepthFirst(Node root)
    {
        if (root == null)
            return;

        System.out.println(root.data);

        recursiveDepthFirst(root.left);
        recursiveDepthFirst(root.right);
    }

    public static boolean recursiveSearchDepthFirst(Node root, int val)
    {
        if (root == null)
            return false;

        if(root.data == val)
            return true;

        return recursiveSearchDepthFirst(root.left, val) || recursiveSearchDepthFirst(root.right, val);
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

        ArrayList<String> result = depthFirstValues(a);
        System.out.println(result); // 5 3 1 4 6 8
    
        recursiveDepthFirst(a); // 5 3 1 4 6 8
        
        boolean searchResult = recursiveSearchDepthFirst(a, 8);
        System.out.println("8 is in tree: " + searchResult);
        
        boolean searchResult2 = recursiveSearchDepthFirst(a, 17);
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
