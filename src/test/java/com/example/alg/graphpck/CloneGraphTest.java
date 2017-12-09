package com.example.alg.graphpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloneGraphTest {
    @Test
    public void cloneGraph() throws Exception {
        final UndirectedGraphNode u0 = getUndirectedGraphNode();

        final CloneGraph c = new CloneGraph();
        final UndirectedGraphNode clone = c.cloneGraph(u0);

        final UndirectedGraphNode expect = getUndirectedGraphNode();

        assertEquals(expect, u0);

    }

    private UndirectedGraphNode getUndirectedGraphNode() {
        final UndirectedGraphNode u0 = new UndirectedGraphNode(0);
        final UndirectedGraphNode u1 = new UndirectedGraphNode(1);
        final UndirectedGraphNode u2 = new UndirectedGraphNode(2);

        u0.neighbors.add(u1);
        u0.neighbors.add(u2);

        u1.neighbors.add(u0);
        u1.neighbors.add(u2);

        u2.neighbors.add(u2);
        return u0;
    }

}