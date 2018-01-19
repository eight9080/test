package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyStringsTest {
    @Test
    public void multiply() throws Exception {

        final MultiplyStrings m = new MultiplyStrings();
        assertEquals("20", m.multiply("10", "2"));

    }

}