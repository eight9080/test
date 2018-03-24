package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MismatchTest {

    @Test
    public void findErrorNums() {

        final Mismatch m = new Mismatch();

        final int[] errorNums = m.findErrorNums(new int[]{3,2,3,4,6,5});
        final int[] expect = {3, 1};

        assertArrayEquals(expect, errorNums);

    }

    @Test
    public void findErrorNums2() {

        final Mismatch m = new Mismatch();

        final int[] errorNums = m.findErrorNums(new int[]{3,2,2});
        final int[] expect = {2, 1};

        assertArrayEquals(expect, errorNums);

    }

    @Test
    public void findErrorNums1() {

        final Mismatch m = new Mismatch();

        final int[] errorNums = m.findErrorNums(new int[]{1, 2, 2, 4});
        final int[] expect = {2, 3};

        assertArrayEquals(expect, errorNums);

    }
}