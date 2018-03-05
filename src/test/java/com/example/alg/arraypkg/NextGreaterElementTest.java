package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreaterElementTest {

    @Test
    public void nextGreaterElement() {
        final NextGreaterElement n = new NextGreaterElement();

        assertArrayEquals(new int[]{-1,3,-1},
                n.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));

        assertArrayEquals(new int[]{3,-1},
                n.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}));
    }
}