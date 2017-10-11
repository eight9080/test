package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionTest {
    @Test
    public void countAndSay2() throws Exception {
        final Conversion c = new Conversion();
        assertEquals("1", c.countAndSay2(1));
        assertEquals("1211", c.countAndSay2(4));
    }

    @Test
    public void countAndSay() throws Exception {
        final Conversion c = new Conversion();
        assertEquals("11", c.countAndSay(1));
        assertEquals("21", c.countAndSay(11));
        assertEquals("1211", c.countAndSay(21));
        assertEquals("111221", c.countAndSay(1211));

    }

    @Test
    public void atoi() throws Exception {
        assertEquals(-324, Conversion.atoi("-324"));
    }

}