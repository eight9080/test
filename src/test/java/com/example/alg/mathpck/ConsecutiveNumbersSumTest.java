package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsecutiveNumbersSumTest {

    @Test
    public void consecutiveNumbersSum() {

        final ConsecutiveNumbersSum c = new ConsecutiveNumbersSum();
        assertEquals(2, c.consecutiveNumbersSum(5));
        assertEquals(3, c.consecutiveNumbersSum(9));
        assertEquals(4, c.consecutiveNumbersSum(15));

    }

}