package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanPlaceFlowersTest {

    @Test
    public void canPlaceFlowers() {

        final CanPlaceFlowers c = new CanPlaceFlowers();
        assertTrue(c.canPlaceFlowers(new int[]{1},0));
        assertTrue(c.canPlaceFlowers(new int[]{1,0,0,0,1},1));
        assertFalse(c.canPlaceFlowers(new int[]{1,0,0,0,1},2));

    }
}
