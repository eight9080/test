package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SlicesTest {
    @Test
    public void numberOfArithmeticSlices() throws Exception {

        final Slices s = new Slices();
        assertEquals(10, s.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
        assertEquals(1, s.numberOfArithmeticSlices(new int[]{1,2,3}));
        assertEquals(0, s.numberOfArithmeticSlices(new int[]{-1, -10}));
        assertEquals(3, s.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));

    }

}