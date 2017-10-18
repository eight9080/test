package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveOpsTest {
    @Test
    public void moveZeroes() throws Exception {
        final MoveOps m = new MoveOps();
        int[] input = new int[]{0, 1, 0, 3, 12};

        m.moveZeroes(input);

        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, input);
    }

}