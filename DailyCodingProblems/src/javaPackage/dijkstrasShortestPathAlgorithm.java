package javaPackage;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstrasShortestPathAlgorithm {

    static class AdjListNode{

        int vertex, weight;

        AdjListNode(int v, int w)
        {
            vertex = v;
            weight = w;
        }

        int getVertex(){ return vertex; };
        int getWeight(){ return weight; };
    }

    // Finds the shortest distance of all the vertices in adjacency list from source node
    public static int[] djistrka(int vertices, ArrayList<ArrayList<AdjListNode>> graph, int source)
    {
        // create array for recorded shortest distances with size of num of vertices
        int[] distance = new int[vertices];

        // Initialize distance array to Infinity so we can find shortest value for each vertice
        for(int i =0; i < vertices; i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<AdjListNode> pq = new PriorityQueue<AdjListNode>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new AdjListNode(source, 0));

        while(!pq.isEmpty())
        {
            AdjListNode curr = pq.poll();

            for(AdjListNode n : graph.get(curr.getVertex()))
            {
                if(distance[curr.getVertex()] + n.getWeight() < distance[n.getVertex()])
                    distance[n.getVertex()] = distance[curr.getVertex()] + n.getWeight();

                pq.add(new AdjListNode(n.getVertex(), distance[n.getVertex()]));
            }
        }

        return distance;
    }
    
}
