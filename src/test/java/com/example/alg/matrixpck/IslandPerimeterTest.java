package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {

    @Test
    public void islandPerimeter() {

        final IslandPerimeter i = new IslandPerimeter();

        int[][] grid =  {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
        };

        final int perimeter = i.islandPerimeter(grid);
        assertEquals(16, perimeter);

    }
}