package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class KLargestElementTest {

    @Test
    public void findKthLargest() throws Exception {
        final int kthLargest = KLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, kthLargest);
    }

    @Test
    public void findKthLargestQuickSort() throws Exception {
        final int kthLargest = KLargestElement.findKthLargestQuickSort(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, kthLargest);
    }

}