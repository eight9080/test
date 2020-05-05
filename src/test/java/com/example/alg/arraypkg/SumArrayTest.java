package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumArrayTest {

    @Test
    public void twoSum() {

        final SumArray s = new SumArray();

        final int[] indexes = s.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertArrayEquals(new int[]{1,2}, indexes);

    }

    @Test
    public void two_sum() {

        final SumArray s = new SumArray();

        final boolean existsTwoSum = s.existsTwoSum(new int[]{2, 7, 11, 15}, 9);

        assertTrue(existsTwoSum);

    }
}