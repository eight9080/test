package com.dg;

import com.example.alg.BubbleSortArray;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortAlgorithmTest {

    @Test
    public void sortBubbleAsc(){
        int unsortedArray[] = { 15, 3, 9, 7, 19, 8, 1, 5 };
        final BubbleSortArray array = new BubbleSortArray(unsortedArray);
        array.bubbleSortAsc();
        assertArrayEquals(new int[]{ 1, 3, 5, 7, 8, 9, 15, 19}, array.getArray());
    }

    @Test
    public void sortBubbleDesc(){
        int unsortedArray[] = { 15, 3, 9, 7, 19, 8, 1, 5 };
        final BubbleSortArray array = new BubbleSortArray(unsortedArray);
        array.bubbleSortDesc();
        assertArrayEquals(new int[]{ 19, 15, 9, 8, 7, 5, 3, 1}, array.getArray());
    }
}
