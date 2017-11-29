package com.example.alg.heappck;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KSortedArrayTest {
    @Test
    public void mergeKSortedArray() throws Exception {

        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        final KSortedArray k = new KSortedArray();

        int[] result = k.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
        int[] expectResult = { 0,1,2,3,4,5,6,7,8,9,10,11};

        assertArrayEquals(expectResult, result);

    }

}