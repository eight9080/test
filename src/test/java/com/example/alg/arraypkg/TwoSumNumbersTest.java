package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumNumbersTest {
    @Test
    public void add() throws Exception {
        final TwoSumNumbers twoSumNumbers = new TwoSumNumbers();
        twoSumNumbers.add(1);
        twoSumNumbers.add(3);
        twoSumNumbers.add(5);

        assertTrue(twoSumNumbers.find(4));
        assertFalse(twoSumNumbers.find(7));

    }

}