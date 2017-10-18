package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveOpsTest {
    @Test
    public void removeElement() throws Exception {
        final RemoveOps r = new RemoveOps();
        int[] input = {3,2,2,3};
        assertEquals(2,r.removeElement(input, 3));
        assertArrayEquals(new int[]{2,2,2,3}, input);
    }

}