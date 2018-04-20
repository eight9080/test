package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PivotTest {

    @Test
    public void pivotIndex() {

        final Pivot p = new Pivot();
        final int pivotIndex = p.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        assertEquals(3, pivotIndex);

    }

    @Test
    public void pivotIndex1() {

        final Pivot p = new Pivot();
        final int pivotIndex = p.pivotIndex(new int[]{1, 2,3});
        assertEquals(-1, pivotIndex);

    }

    @Test
    public void pivotIndex3() {

        final Pivot p = new Pivot();
        final int pivotIndex = p.pivotIndex(new int[]{-1,-1,-1,0,1,1});
        assertEquals(0, pivotIndex);

    }
}