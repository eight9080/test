package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {
    @Test
    public void fractionToDecimal() throws Exception {
        final Fraction f = new Fraction();

        assertEquals("-2147483648", f.fractionToDecimal(-2147483648,1));
        assertEquals("-6.25", f.fractionToDecimal(-50,8));
        assertEquals("0.5", f.fractionToDecimal(1,2));
        assertEquals("2", f.fractionToDecimal(2,1));
        assertEquals("0.(6)", f.fractionToDecimal(2,3));

    }

}