package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchArrayTest {
    @Test
    public void minSwapsCouples() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(1, sA.minSwapsCouples(new int[]{0,2,1,3}));
        assertEquals(0, sA.minSwapsCouples(new int[]{3,2,0,1}));
    }

    @Test
    public void missingNumber() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(2, sA.missingNumber(new int[]{3,0,1}));
        assertEquals(8, sA.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void firstMissingPositive() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(2, sA.firstMissingPositive(new int[]{4,1,3,3}));
        assertEquals(2, sA.firstMissingPositive(new int[]{3,4,-1,1}));
        assertEquals(3, sA.firstMissingPositive(new int[]{1,2,0}));

    }

    @Test
    public void findMinDuplicates() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(1, sA.findMinDuplicates(new int[]{10,1,10,10,10}));
        assertEquals(1, sA.findMinDuplicates(new int[]{1,1}));
        assertEquals(1, sA.findMinDuplicates(new int[]{1}));
        assertEquals(0, sA.findMinDuplicates(new int[]{6,7,0,1,1,2,3,4,4,5}));
        assertEquals(0, sA.findMinDuplicates(new int[]{2,3,4,0,1,2}));
    }

    @Test
    public void findMin() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(0, sA.findMin(new int[]{6,7,0,1,2,3,4,5}));
        assertEquals(0, sA.findMin(new int[]{2,3,4,0,1,2}));
    }

    @Test
    public void searchRotateArrayIDuplicate() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(true, sA.searchRotateArrayIDuplicate(new int[]{6,7,0,1,1,2,3,4,4,5}, 7));
        assertEquals(true, sA.searchRotateArrayIDuplicate(new int[]{2,3,4,0,1,2}, 1));
    }

    @Test
    public void searchRotateArrayI() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(1, sA.searchRotateArrayI(new int[]{3,1}, 1));
        assertEquals(1, sA.searchRotateArrayI(new int[]{6,7,0,1,2,3,4,5}, 7));
        assertEquals(-1, sA.searchRotateArrayI(new int[]{6,7,0,1,2,3,4,5}, 9));
    }

    @Test
    public void searchRotateArrayR() throws Exception {
        final SearchArray sA = new SearchArray();
        assertEquals(1, sA.searchRotateArrayR(new int[]{6,7,0,1,2,3,4,5}, 7));
        assertEquals(-1, sA.searchRotateArrayR(new int[]{6,7,0,1,2,3,4,5}, 9));
    }

    @Test
    public void searchRange() throws Exception {
        final SearchArray sA = new SearchArray();
        assertArrayEquals(new int[]{3, 4}, sA.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, sA.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 33));
    }

    @Test
    public void searchInsert() throws Exception {
        assertEquals(2, SearchArray.searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, SearchArray.searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, SearchArray.searchInsert(new int[]{1,3,5,6}, 7));
        assertEquals(0, SearchArray.searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void searchSmallestNumber(){
        assertEquals(Integer.valueOf(2), SearchArray.searchSmallestNumber(new int[]{2, 1, 3, 1, 2, 2}, 3));
        assertEquals(Integer.valueOf(3), SearchArray.searchSmallestNumber(new int[]{3, 4, 3, 2, 1, 5, 5}, 2));
    }


}