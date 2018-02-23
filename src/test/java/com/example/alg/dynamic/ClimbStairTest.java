package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbStairTest {

    @Test
    public void climbStairs() {

        final ClimbStair c = new ClimbStair();
        assertEquals(2, c.climbStairs(2));
        assertEquals(3, c.climbStairs(3));

    }

    @Test
    public void minCostClimbingStairs() {

        final ClimbStair c = new ClimbStair();
        assertEquals(15, c.minCostClimbingStairs(new int[]{10,15,20}));
        assertEquals(6, c.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}