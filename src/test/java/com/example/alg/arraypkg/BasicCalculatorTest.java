package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    @Test
    public void calculate() throws Exception {

        final BasicCalculator bc = new BasicCalculator();
        assertEquals(2, bc.calculate("1+1"));
        assertEquals(1, bc.calculate("(1)"));
        assertEquals(2, bc.calculate("(1-(4-5))"));

    }

}