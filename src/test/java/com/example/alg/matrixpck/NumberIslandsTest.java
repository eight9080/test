package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberIslandsTest {
    @Test
    public void numIslands() throws Exception {
        final NumberIslands n = new NumberIslands();
        char[][] input = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        assertEquals(1, n.numIslands(input));
    }

    @Test
    public void numIslands1() throws Exception {
        final NumberIslands n = new NumberIslands();
        char[][] input = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        assertEquals(3, n.numIslands(input));
    }

    @Test
    public void numIslands2() throws Exception {
        final NumberIslands n = new NumberIslands();
        char[][] input = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        assertEquals(1, n.numIslands(input));
    }

}