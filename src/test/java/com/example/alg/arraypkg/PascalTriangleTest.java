package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class PascalTriangleTest {
    @Test
    public void getRow() throws Exception {
        final PascalTriangle p = new PascalTriangle();
        assertEquals(asList(1), p.getRow(0));
        assertEquals(asList(1, 1), p.getRow(1));
        assertEquals(asList(1,2, 1), p.getRow(2));
        assertEquals(asList(1,3,3, 1), p.getRow(3));
        assertEquals(asList(1,4,6,4, 1), p.getRow(4));
    }

    @Test
    public void generate() throws Exception {
        final PascalTriangle p = new PascalTriangle();
        assertEquals(asList(singletonList(1), asList(1,1), asList(1,2,1), asList(1,3,3,1), asList(1,4,6,4, 1)),
                p.generate(5));
    }

}