package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogJumpTest {

    @Test
    public void canCross() {

        final FrogJump f = new FrogJump();
        assertTrue(f.canCross(new int[]{0,1,3,5,6,8,12,17}));
        assertFalse(f.canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}