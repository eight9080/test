package com.example.alg.greedypkg;

import java.util.*;

/**
 * Kruskal’s algorithm for finding the Minimum Spanning Tree(MST), which finds an edge of the least possible weight that connects any two trees in the forest
 * It is a greedy algorithm.
 * It finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.
 * If the graph is not connected, then it finds a minimum spanning forest (a minimum spanning tree for each connected component).
 * Number of edges in MST: V-1 (V – no of vertices in Graph).
 * ---
 * Sort the edges in ascending order of weights.
 * Pick the edge with the least weight. Check if including this edge in spanning tree will form a cycle is Yes then ignore it if No then add it to spanning tree.
 * Repeat the step 2 till spanning tree has V-1 (V – no of vertices in Graph).
 * Spanning tree with least weight will be formed, called Minimum Spanning Tree
 */
public class KrushkalMST {

    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph {
        int vertices;
        List<Edge> allEdges = new ArrayList<>();

        public Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); //add to total edges
        }


    }

    public List<Edge> kruskalMST(Graph g) {
        PriorityQueue<Edge> pQueue = new PriorityQueue<>(g.allEdges.size(),
                Comparator.comparingInt(e -> e.weight));
        //sort the edges by weight
        pQueue.addAll(g.allEdges);

        //create parent
        int[] parent = new int[g.vertices];

        //makeset
        makeSet(parent, g.vertices);

        List<Edge> minSpanningTree = new ArrayList<>();

        int index = 0;
        while (index < g.vertices - 1) {

            final Edge edge = pQueue.remove();

            //check if adding this edge creates a cycle
            final int x = find(parent, edge.source);
            final int y = find(parent, edge.destination);

            if (x == y) {
                //it is a cycle, this edge is ignored
                continue;
            }

            minSpanningTree.add(edge);

            union(parent, x, y);
            System.out.println("Parent :"+Arrays.toString(parent));

            index++;

        }

        return minSpanningTree;

    }

    private void union(int[] parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        //make x as parent of y
        parent[yParent] = xParent;
    }

    private int find(int[] parent, int vertex) {
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        return vertex;
    }

    private void makeSet(int[] parent, int vertices) {
        //creating a new element with a parent pointer to itself
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    public static void printGraph(List<Edge> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Edge-" + i + " source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
    }


}


