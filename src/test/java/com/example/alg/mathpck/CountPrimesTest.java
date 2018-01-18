package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {
    @Test
    public void countPrimes() throws Exception {

        final CountPrimes c = new CountPrimes();
        assertEquals(10, c.countPrimes(30));

    }

}