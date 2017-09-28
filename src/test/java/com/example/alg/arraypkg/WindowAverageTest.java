package com.example.alg.arraypkg;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class WindowAverageTest {


    @Test
    public void next() throws Exception {
        final WindowAverage windowAverage = new WindowAverage(3);

        assertEquals(new BigDecimal("1.0"), windowAverage.next(1));
        assertEquals(new BigDecimal("1.5"), windowAverage.next(2));
        assertEquals(new BigDecimal("2.0"), windowAverage.next(3));
        assertEquals(new BigDecimal("3.0"), windowAverage.next(4));

    }

}