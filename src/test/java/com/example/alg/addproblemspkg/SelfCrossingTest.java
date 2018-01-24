package com.example.alg.addproblemspkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelfCrossingTest {
    @Test
    public void isSelfCrossing() throws Exception {

        final SelfCrossing s = new SelfCrossing();
        assertTrue(s.isSelfCrossing(new int[]{2, 1, 1, 2}));
        assertFalse(s.isSelfCrossing(new int[]{1,2,3,4}));

    }

}