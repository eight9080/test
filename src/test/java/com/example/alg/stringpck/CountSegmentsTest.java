package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSegmentsTest {

    @Test
    public void countSegments() {

        final CountSegments c = new CountSegments();
        assertEquals(0, c.countSegments("                "));

        assertEquals(5, c.countSegments("Hello, my name is John"));
    }
}