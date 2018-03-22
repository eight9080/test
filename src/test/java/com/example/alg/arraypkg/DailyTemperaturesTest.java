package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperaturesTest {

    @Test
    public void dailyTemperatures() {

        final DailyTemperatures d = new DailyTemperatures();
        final int[] diffDays = d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, diffDays);
    }
}