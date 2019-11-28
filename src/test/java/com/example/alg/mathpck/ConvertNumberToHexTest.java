package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertNumberToHexTest {

    @Test
    public void toHex() {

        final ConvertNumberToHex converter = new ConvertNumberToHex();
        assertEquals("1a", converter.toHex(26));
        assertEquals("ffffffff", converter.toHex(-1));
    }
}