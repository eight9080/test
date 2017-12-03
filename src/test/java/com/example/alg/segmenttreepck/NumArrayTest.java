package com.example.alg.segmenttreepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {
    @Test
    public void sumRange() throws Exception {

        final NumArray n = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1,n.sumRange(0,2));
        assertEquals(-1,n.sumRange(2,5));
        assertEquals(-3,n.sumRange(0,5));
    }

}