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

    @Test
    public void nextGreaterElements() {

        final NextGreaterElement b = new NextGreaterElement();
        assertArrayEquals(new int[]{2,3,4,-1,4},
                b.nextGreaterElements(new int[]{1,2,3,4,3}));
        assertArrayEquals(new int[]{2,-1,2},
                b.nextGreaterElements(new int[]{1,2,1}));
        assertArrayEquals(new int[]{3,-1,3,3},
                b.nextGreaterElements(new int[]{1,3,2,1}));
    }
    @Test
    public void nextGreaterElements2() {

        final NextGreaterElement b = new NextGreaterElement();
        assertArrayEquals(new int[]{2,3,4,-1,4},
                b.nextGreaterElements2(new int[]{1,2,3,4,3}));
        assertArrayEquals(new int[]{2,-1,2},
                b.nextGreaterElements2(new int[]{1,2,1}));
        assertArrayEquals(new int[]{3,-1,3,3},
                b.nextGreaterElements2(new int[]{1,3,2,1}));
    }
}