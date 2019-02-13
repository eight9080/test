package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonotomicArrayTest {

    @Test
    public void isMonotonic() {
        final MonotomicArray m = new MonotomicArray();

        assertTrue(m.isMonotonic(new int[]{1,2,2,3}));
        assertTrue(m.isMonotonic(new int[]{6,5,4,4}));
        assertFalse(m.isMonotonic(new int[]{1,3,2}));
        assertTrue(m.isMonotonic(new int[]{1,2,4,5}));
        assertTrue(m.isMonotonic(new int[]{1,1,1}));
        assertTrue(m.isMonotonic(new int[]{1,1,2}));

    }
}