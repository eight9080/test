package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchArrayTest {
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