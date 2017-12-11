package com.example.alg.graphpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinHeightGraphTest {
    @Test
    public void findMinHeightTrees() throws Exception {
        final MinHeightGraph m = new MinHeightGraph();
        final List<Integer> minHeightTrees = m.findMinHeightTrees(4, new int[][]{
                {1, 0},
                {1, 2},
                {1, 3}
        });

        assertEquals(Arrays.asList(1), minHeightTrees);

    }

    @Test
    public void findMinHeightTrees1() throws Exception {
        final MinHeightGraph m = new MinHeightGraph();
        final List<Integer> minHeightTrees = m.findMinHeightTrees(6, new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        });

        assertEquals(Arrays.asList(3,4), minHeightTrees);

    }

}