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
}