package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlusOneTest {
    @Test
    public void plusOne() throws Exception {

        final PlusOne p = new PlusOne();
        assertArrayEquals(new int[]{1,2,4}, p.plusOne(new int[]{1,2,3}));
        assertArrayEquals(new int[]{1,3,0}, p.plusOne(new int[]{1,2,9}));
        assertArrayEquals(new int[]{1,0,0}, p.plusOne(new int[]{9,9}));

    }

}