package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void trailingZeroes() throws Exception {

        final Factorial f = new Factorial();
        final int trailingZeroes = f.trailingZeroes(10);
        assertEquals(2, trailingZeroes);

    }

}