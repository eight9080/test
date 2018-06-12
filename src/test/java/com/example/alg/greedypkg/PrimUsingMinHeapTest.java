package com.example.alg.greedypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimUsingMinHeapTest {

    @Test
    public void primMST() {
        int vertices = 6;
        PrimUsingMinHeap.Graph graph = new PrimUsingMinHeap.Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        final PrimUsingMinHeap p = new PrimUsingMinHeap();
        final PrimUsingMinHeap.ResultSet[] resultSets = p.primMST(graph);
        assertEquals(6, resultSets.length);
        PrimUsingMinHeap.printMST(resultSets);
    }
}