package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveOpsTest {
    @Test
    public void containsNearbyDuplicate2() throws Exception {
        final MoveOps m = new MoveOps();
        assertTrue(m.containsNearbyDuplicate2(new int [] {2,2}, 3));
        assertTrue(m.containsNearbyDuplicate2(new int [] {1,3,4,3,5}, 2));
    }

    @Test
    public void containsDuplicate() throws Exception {
        final MoveOps m = new MoveOps();
        assertTrue(m.containsDuplicate(new int [] {1,8,2,8,3,1}));
        assertFalse(m.containsDuplicate(new int [] {1,8,2,3,7}));
    }

    @Test
    public void moveZeroes() throws Exception {
        final MoveOps m = new MoveOps();
        int[] input = new int[]{0, 1, 0, 3, 12};

        m.moveZeroes(input);

        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, input);
    }

}