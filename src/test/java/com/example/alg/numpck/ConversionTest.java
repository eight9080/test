package com.example.alg.numpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionTest {

    @Test
    public void convertToBase3() {
        final Conversion conversion = new Conversion();
        assertEquals("1022", Conversion.convertToBase3(35));
    }
}