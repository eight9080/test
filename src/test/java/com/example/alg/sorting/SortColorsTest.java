package com.example.alg.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {


    @Test
    public void sortColors() {

        final SortColors s = new SortColors();
        final int[] input = {2, 0, 1, 1, 2, 2, 0};
        s.sortColors(input);
        assertArrayEquals(new int[]{0,0,1,1,2,2,2}, input);


    }


    @Test
    public void sortColors2() {

        final SortColors s = new SortColors();
        final int[] input = {2, 0, 1, 1, 2, 2, 0};
        s.sortColors2(input);
        assertArrayEquals(new int[]{0,0,1,1,2,2,2}, input);


    }


}