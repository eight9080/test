package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchArrayTest {
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