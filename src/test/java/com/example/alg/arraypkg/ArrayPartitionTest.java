package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartitionTest {

    @Test
    public void arrayPairSum() {

        final ArrayPartition a = new ArrayPartition();
        final int pairSum = a.arrayPairSum(new int[]{1, 4, 3, 2});
        assertEquals(4, pairSum);
    }
}