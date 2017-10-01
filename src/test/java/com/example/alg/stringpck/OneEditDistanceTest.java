package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneEditDistanceTest {
    @Test
    public void isOneEditDistance() throws Exception {
        assertTrue(OneEditDistance.isOneEditDistance("dar", "daar"));
        assertTrue(OneEditDistance.isOneEditDistance("zoom", "boom"));
        assertFalse(OneEditDistance.isOneEditDistance("odom", "boom"));
        assertFalse(OneEditDistance.isOneEditDistance("glory", "glorious"));
    }

}