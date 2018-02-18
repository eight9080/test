package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideIntegersTest {

    @Test
    public void divide() {
        final DivideIntegers d = new DivideIntegers();
        assertEquals(2147483647, d.divide(-2147483648, -1));
        assertEquals(4, d.divide(8, 2));



    }
}