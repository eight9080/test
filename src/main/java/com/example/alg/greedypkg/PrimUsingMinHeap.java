package com.example.alg.greedypkg;

import java.util.LinkedList;

public class PrimUsingMinHeap {

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

    public static class HeapNode{
        int vertex;
        int key;
    }

    public static class ResultSet {
        int parent;
        int weight;
    }

    public static class Graph{
        int vertices;
        LinkedList<Edge>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        //undirected graph
        public void addEdge(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencyList[destination].addFirst(edge);
        }

    }

    public ResultSet[] primMST(Graph g) {

        //keys used to store the key to know whether min heap update is required
        int[] key = new int[g.vertices];

        boolean[] inHeap = new boolean[g.vertices];

        ResultSet[] resultSets = new ResultSet[g.vertices];
        HeapNode[] heapNodes = new HeapNode[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = Integer.MAX_VALUE;

            resultSets[i] = new ResultSet();
            resultSets[i].parent = -1;

            inHeap[i] = true;

            key[i] = Integer.MAX_VALUE;

        }

        //decrease the key for the first index
        heapNodes[0].key = 0;


        //add all the vertices to the MinHeap
        MinHeap minHeap = new MinHeap(g.vertices);
        //add all the vertices to priority queue
        for (int i = 0; i <g.vertices ; i++) {
            minHeap.insert(heapNodes[i]);
        }

        while (!minHeap.isEmpty()){
            HeapNode minNode = minHeap.extractMin();

            inHeap[minNode.vertex]=false;

            final LinkedList<Edge> edges = g.adjacencyList[minNode.vertex];
            for (Edge edge: edges) {

                if(inHeap[edge.destination]){

                    if(key[edge.destination]>edge.weight){
                        decreseKey(minHeap, edge.weight, edge.destination);
                        //update the parent node for destination
                        resultSets[edge.destination].parent = minNode.vertex;
                        resultSets[edge.destination].weight = edge.weight;
                        key[edge.destination] = edge.weight;
                    }

                }
            }
        }
        return resultSets;
    }

    private void decreseKey(MinHeap minHeap, int weight, int destination) {
        //get the index which key's needs a decrease;
        int index = minHeap.indexes[destination];

        //get the node and update its value
        HeapNode node = minHeap.mH[index];
        node.key= weight;
        minHeap.bubbleUp(index);
    }

    public  static void printMST(ResultSet[] resultSet){
        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i <resultSet.length ; i++) {
            System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                    " weight: " + resultSet[i].weight);
            total_min_weight += resultSet[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }
}
