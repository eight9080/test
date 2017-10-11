package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {
    @Test
    public void trap() throws Exception {
        final TrappingRainWater tr = new TrappingRainWater();
        assertEquals(6, tr.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}