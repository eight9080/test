package com.example.alg.random;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LexicographicalNumbersTest {

    @Test
    public void lexicalOrder() {
        final LexicographicalNumbers l = new LexicographicalNumbers();
        final List<Integer> result = l.lexicalOrder(13);
        final List<Integer> expect = Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expect, result);
    }
}