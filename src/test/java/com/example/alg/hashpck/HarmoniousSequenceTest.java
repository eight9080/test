package com.example.alg.hashpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class HarmoniousSequenceTest {

    @Test
    public void findLHS() {
        final HarmoniousSequence h = new HarmoniousSequence();
        assertEquals(5, h.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}