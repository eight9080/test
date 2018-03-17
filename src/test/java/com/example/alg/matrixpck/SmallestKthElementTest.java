package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestKthElementTest {

    @Test
    public void kthSmallest() {

        final SmallestKthElement s = new SmallestKthElement();
        int[][] input = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        final int kthSmallest = s.kthSmallest(input, 8);
        assertEquals(13, kthSmallest);

    }

    @Test
    public void kthSmallest1() {

        final SmallestKthElement s = new SmallestKthElement();
        int[][] input = {
                {1,2},
                {1,3}
        };
        final int kthSmallest = s.kthSmallest(input, 2);
        assertEquals(1, kthSmallest);

    }

    @Test
    public void kthSmallest2() {

        final SmallestKthElement s = new SmallestKthElement();
        int[][] input = {
                {-5}
        };
        final int kthSmallest = s.kthSmallest(input, 1);
        assertEquals(-5, kthSmallest);

    }
}
