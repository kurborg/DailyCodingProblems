package javaPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
    
    private Map<Node, List<Node>> map = new HashMap<>();

    public void depthFirstPrint(Node sn)
    {
        Map<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();

        visitedMap.put(sn, true);
        Stack<Node> stack = new Stack<Node>();
        stack.add(sn);

        while(!stack.isEmpty())
        {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            for(Node dd : map.get(curr))
            {
                if(!visitedMap.containsKey(dd))
                {
                    visitedMap.put(dd, false);
                }

                if(visitedMap.get(dd) != true)
                {
                    visitedMap.put(dd, true);
                    stack.add(dd);
                }
            }
        }

        System.out.print("\n");
    }

    public void breadthFirstPrint(Node sn)
    {
        Map<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();

        visitedMap.put(sn, true);
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(sn);

        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            for(Node dd : map.get(curr))
            {
                if(!visitedMap.containsKey(dd))
                {
                    visitedMap.put(dd, false);
                }

                if(visitedMap.get(dd) != true)
                {
                    visitedMap.put(dd, true);
                    queue.add(dd);
                }
            }
            
        }

        System.out.print("\n");
    }

    public void addVertex(Node s)
    {
        map.put(s, new LinkedList<Node>());
    }

    public void addEdge(Node s, Node d)
    {
        addEdge(s, d, false);
    }

    public void addEdge(Node s, Node d, boolean bidirectional)
    {
        if(!map.containsKey(s))
            addVertex(s);
        if(!map.containsKey(d))
            addVertex(d);

        map.get(s).add(d);

        if(bidirectional)
        {
            map.get(d).add(s);
        }
    }

    public int getVertexCount()
    {
        int count = map.keySet().size();

        System.out.println("Graph has Vertex count: " +
        count);
        return count;
    }

    public void getEdgeCount()
    {
        getEdgeCount(false);
    }

    public void getEdgeCount(boolean bidirectional)
    {
        int count = 0;
        for(Node v : map.keySet())
        {
            count += map.get(v).size();
        }

        if(bidirectional)
            count = count / 2;
        
        System.out.println("Graph has Edge count: " +
        count);
    }

    public void hasVertex(Node s)
    {
        if(map.containsKey(s))
        {
            System.out.println("Graph contains Vertex: " + s);
        }
        else
        {
            System.out.println("Graph does noNode contain Vertex: " + s);
        }
    }

    public void hasEdge(Node s, Node d)
    {
        if(map.get(s).contains(d))
        {
            System.out.println("Graph contains Edge: " + s + " to " + d);
        }
        else
        {
            System.out.println("Graph does noNode contain Edge: " + s + " to " + d);
        }
    }

    public void graphToString()
    {
        StringBuilder sb = new StringBuilder();

        for(Node s : map.keySet())
        {
            sb.append(s.data + ": ");
            for(Node d : map.get(s))
            {
                    sb.append(d.data + ", ");
            }

            sb.deleteCharAt(sb.length()-2);
            sb.append("\n");
        }

        System.out.println(sb.toString());   
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph();

        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node (2);
        Node three = new Node(3);
        Node four = new Node(4);

        graph.addEdge(zero, one);
        graph.addEdge(zero, three);
        graph.addEdge(zero, two);
        graph.addEdge(one, two);
        graph.addEdge(one, four);
        graph.addEdge(two, three);
        graph.addEdge(two, zero);
        graph.addEdge(three, four);
        graph.addEdge(four, one);
        graph.addEdge(four, two);

        //graph.graphToString();

        graph.breadthFirstPrint(zero);
        graph.depthFirstPrint(zero);
    }
}
