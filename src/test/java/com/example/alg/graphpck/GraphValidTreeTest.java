package com.example.alg.graphpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphValidTreeTest {

    private GraphValidTree g = new GraphValidTree();

    @Test
    public void validTreeBFS() throws Exception {
        final boolean b = g.validTreeBFS(6, new int[][]{
                {0, 3},
                {0, 1},
                {3, 2},
                {2, 4},
                {4, 5}
        });
        assertTrue(b);
    }

    @Test
    public void validTree() throws Exception {

        final boolean b = g.validTree(6, new int[][]{
                {0, 3},
                {0, 1},
                {3, 2},
                {2, 4},
                {4, 5}
        });
        assertTrue(b);
    }

}