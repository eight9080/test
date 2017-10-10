package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    @Test
    public void calculate2() throws Exception {
        final BasicCalculator bc = new BasicCalculator();

        assertEquals(7, bc.calculate(" 3+2*2 "));
        assertEquals(0, bc.calculate(" 0*0 "));
    }

    @Test
    public void calculate() throws Exception {

        final BasicCalculator bc = new BasicCalculator();

        assertEquals(3, bc.calculate(" 2-1 + 2 "));

        assertEquals(2147483647, bc.calculate("2147483647"));

        assertEquals(2, bc.calculate("1+1"));
        assertEquals(1, bc.calculate("(1)"));
        assertEquals(2, bc.calculate("(1-(4-5))"));
        assertEquals(23, bc.calculate("(1+(4+5+2)-3)+(6+8)"));

    }

}