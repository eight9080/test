package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberTest {
    @Test
    public void largestNumber() throws Exception {
        final LargestNumber l = new LargestNumber();
        assertEquals("0", l.largestNumber(new int[]{0,0}));
        assertEquals("9534330", l.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}