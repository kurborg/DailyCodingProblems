package javaPackage;

import java.util.ArrayList;
import java.util.HashMap;

public class graphCloneCopy {

    class Node
    {
        int data;
        ArrayList<Node> neighbors;

        Node(int data_)
        {
            data = data_;
            neighbors = new ArrayList<>();
        }
    }

    public HashMap<Integer, Node> oldToNew = new HashMap<>();

    public Node cloneGraph(Node root)
    {
        return graphDFSClone(root);
    }

    public Node graphDFSClone(Node root)
    {
        if(root == null)
            return null;

        if(oldToNew.containsKey(root.data))
        {
            return oldToNew.get(root.data);
        }
        else
        {
            Node copy = new Node(root.data);
            oldToNew.put(copy.data, copy);
            for(Node neighbor : root.neighbors)
                copy.neighbors.add(graphDFSClone(neighbor));
            return copy;
        }
    }
    public static void main(String[] args)
    {

    }
    
}
