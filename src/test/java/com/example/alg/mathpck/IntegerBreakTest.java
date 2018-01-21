package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerBreakTest {
    @Test
    public void integerBreak() throws Exception {
        final IntegerBreak i = new IntegerBreak();
        assertEquals(6, i.integerBreak(5));
        assertEquals(4, i.integerBreak(4));
        assertEquals(36, i.integerBreak(10));

    }

}