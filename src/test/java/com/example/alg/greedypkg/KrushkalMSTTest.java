package com.example.alg.greedypkg;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KrushkalMSTTest {

    @Test
    public void kruskalMST() {
        int vertices = 6;
        KrushkalMST.Graph graph = new KrushkalMST.Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 2, 1);
        graph.addEgde(1, 3, 2);
        graph.addEgde(2, 3, 4);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 5, 6);
        final List<KrushkalMST.Edge> edges = new KrushkalMST().kruskalMST(graph);

        assertEquals(5, edges.size());

        KrushkalMST.printGraph(edges);

    }
}