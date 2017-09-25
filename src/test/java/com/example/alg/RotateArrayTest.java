package com.example.alg;

import com.example.alg.arraypkg.RotateArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {
    @Test
    public void rotate() throws Exception {
        final int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotate(input1, 3);
        assertArrayEquals(input1, new int[]{5,6,7,1,2,3,4});

        final int[] input2 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotate(input2, 9);
        assertArrayEquals(input2, new int[]{6,7,1,2,3,4, 5});
    }

    @Test
    public void bubbleRotate() throws Exception {
        final int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.bubbleRotate(input1, 3);
        assertArrayEquals(input1, new int[]{5,6,7,1,2,3,4});

        final int[] input2 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.bubbleRotate(input2, 9);
        assertArrayEquals(input2, new int[]{6,7,1,2,3,4, 5});

    }

    @Test
    public void reverseRotate() throws Exception {
        final int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.reverseRotate(input1, 3);
        assertArrayEquals(input1, new int[]{5,6,7,1,2,3,4});

        final int[] input2 = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.reverseRotate(input2, 9);
        assertArrayEquals(input2, new int[]{6,7,1,2,3,4, 5});

    }
}