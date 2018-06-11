package com.example.alg.greedypkg;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Prim’s – Minimum Spanning Tree (MST) |using Adjacency List and Priority Queue with decrease key
 * https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-with-decrease-key/
 *
 *
 Create priority queue of size = no of vertices.
 Create a heapNode for each vertex which will store two information’s.
 Vertex
 key
 Use inPriorityQueue[] to keep track of the vertices which are currently in priority queue.
 Create key[] to keep track of key value for each vertex. (keep updating it as heapNode key for each vertex)
 For each heapNode, initialize key as MAX_VAL except the heapNode for the first vertex for which key will 0. (Start from first vertex).
 Override the Comparator of priority queue to sort them based on the key. Insert all the heapNodes into priority queue. inPriorityQueue [v] = true for all vertices.
 while priority queue is not empty
 Extract the min node from the priority queue, say it vertex u and add it to the MST.
 Decrease key: Iterate through all the adjacent vertices of above vertex u and if adjacent vertex(say it’s v) is still part of inPriorityQueue [] (means not in MST) and key of vertex v> u-v weight then update the node in priority queue. Find the node for vertex v in priority queue, remove it, and update it as key of vertex v = u-v weight and insert it again. This step increases the complexity of this implementation.
 We will use Result object to store the result of each vertex. Result object will store 2 information’s.
 First the parent vertex means from which vertex you can visit this vertex. Example if for vertex v, you have included edge u-v in mst[] then vertex u will be the parent vertex.
 Second weight of edge u-v. If you add all these weights for all the vertices in mst[] then you will get Minimum spanning tree weight.

 */
public class PrimsPQ {
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

    public class HeapNode{
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
        public void addEgde(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencyList[destination].addFirst(edge);
        }

    }

    public ResultSet[] primMST(Graph g){

        //keys used to store the key to know whether priority queue update is required
        int [] key = new int[g.vertices];

        boolean[] inPriorityQueue = new boolean[g.vertices];
        ResultSet[] resultSets = new ResultSet[g.vertices];
        HeapNode[] heapNodes = new HeapNode[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = Integer.MAX_VALUE;

            resultSets[i] = new ResultSet();
            resultSets[i].parent=-1;

            inPriorityQueue[i]= true;

            key[i] = Integer.MAX_VALUE;

        }

        //decrease the key for the first index
        heapNodes[0].key = 0;

        //add all vertices to the PQ
        PriorityQueue<HeapNode> pq = new PriorityQueue<>(g.vertices,
                Comparator.comparingInt((HeapNode a) -> a.key));

        for (int i = 0; i < g.vertices; i++) {
            pq.offer(heapNodes[i]);
        }

        while (!pq.isEmpty()){


            //extract min
            final HeapNode exractedNode = pq.poll();

            inPriorityQueue[exractedNode.vertex]=false;

            final LinkedList<Edge> edges = g.adjacencyList[exractedNode.vertex];
            for (Edge edge : edges) {
                //only if edge destination is present in heap
                final int destination = edge.destination;
                if(inPriorityQueue[destination]){
                    final int newKey = edge.weight;
                    //check if updated key < existing key, if yes, update if
                    if(newKey<key[destination]){
                        decreaseKey(pq, newKey, destination);
                        //update the parent node for destination
                        resultSets[destination].parent = exractedNode.vertex;
                        resultSets[destination].weight = newKey;
                        key[destination]=newKey;
                    }
                }
            }

        }
        return resultSets;

    }

    private void decreaseKey(PriorityQueue<HeapNode> pq, int newKey, int destination) {
//        pq.forEach(node -> {
//            if(node.vertex==destination){
//                node.key=newKey;
//            }
//        });
        final Iterator<HeapNode> iterator = pq.iterator();
        while (iterator.hasNext()){
            final HeapNode node = iterator.next();
            pq.remove(node);
            if(node.vertex==destination){
                node.key=newKey;
            }
            pq.offer(node);
            break;
        }
    }

    public static void printMST(ResultSet[] resultSet){
        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i <resultSet.length ; i++) {
            System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                    " key: " + resultSet[i].weight);
            total_min_weight += resultSet[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }

}
