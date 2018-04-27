package com.example.alg.mathpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DivideIntegersTest {

    @Test
    public void divide() {
        final DivideIntegers d = new DivideIntegers();
        assertEquals(2147483647, d.divide(-2147483648, -1));
        assertEquals(4, d.divide(8, 2));



    }

    @Test
    public void selfDividingNumbers() {

        final DivideIntegers d = new DivideIntegers();
        final List<Integer> integers = d.selfDividingNumbers(1, 22);
        final List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        assertEquals(expect, integers);

    }
}