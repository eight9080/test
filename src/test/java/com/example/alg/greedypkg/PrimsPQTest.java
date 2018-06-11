package com.example.alg.greedypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimsPQTest {

    @Test
    public void primMST() {
        int vertices = 6;
        PrimsPQ.Graph graph = new PrimsPQ.Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 2, 1);
        graph.addEgde(1, 3, 2);
        graph.addEgde(2, 3, 4);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 5, 6);

        final PrimsPQ primsPQ = new PrimsPQ();
        final PrimsPQ.ResultSet[] resultSets = primsPQ.primMST(graph);
        assertEquals(6, resultSets.length);

        PrimsPQ.printMST(resultSets);

    }
}