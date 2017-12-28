package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DungeonGameTest {

    @Test
    public void calculateMinimumHP() {

        final DungeonGame d = new DungeonGame();
        final int minimumHP = d.calculateMinimumHP(
                new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                });
        assertEquals(7, minimumHP);

    }

}