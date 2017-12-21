package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {
    @Test
    public void robDP() throws Exception {
        final HouseRobber h = new HouseRobber();
        assertEquals(4, h.robDP(new int[]{2,1,1,2}));
        assertEquals(70, h.robDP(new int[]{10,20,4,50,30}));

    }

    @Test
    public void rob() throws Exception {

        final HouseRobber h = new HouseRobber();
        assertEquals(4, h.rob(new int[]{2,1,1,2}));
        assertEquals(70, h.rob(new int[]{10,20,4,50,30}));

    }

}