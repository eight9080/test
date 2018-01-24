package com.example.alg.addproblemspkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatchingArrayTest {
    @Test
    public void minPatches() throws Exception {

        final PatchingArray p = new PatchingArray();
        assertEquals(3, p.minPatches(new int[]{1,4,10}, 50));

        assertEquals(1, p.minPatches(new int[]{1,3}, 6));
        assertEquals(2, p.minPatches(new int[]{1,5,10}, 20));
        assertEquals(0, p.minPatches(new int[]{1,2,2}, 5));

    }
}