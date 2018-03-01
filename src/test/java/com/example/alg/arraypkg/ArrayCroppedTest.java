package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayCroppedTest {

    @Test
    public void test() {
        int[][][] example = {
                {{0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {1, 1, 1, 0},
                        {0, 0, 0, 0}},

                {{0, 1, 0},
                        {0, 0, 1},
                        {1, 1, 1}}
        };
        int[][] res = ArrayCropped.getCroppedFieldAsArray(example[0]);
        assertArrayEquals(example[1], res);
    }

    @Test
    public void test2() {
        int[][][] example = {
                         {{0,0,0,0},
                        {0,0,1,0},
                        {0,1,1,0},
                        {0,0,0,1}},

                         {{0,1,0},
                        {1,1,0},
                        {0,0,1}}
        };
        int[][] res = ArrayCropped.getCroppedFieldAsArray(example[0]);
        assertArrayEquals(example[1], res);
    }


    @Test
    public void test5() {

        final int size = 10;
        final int offset = (int) (Math.random() * (size / 2) + 1);
        int[][] src = new int[size][size];
        for (int i = offset; i < size - offset; i++) {
            for (int j = offset; j < size - offset; j++) {
                src[i][j] = (int) (Math.random() * 2);
            }
        }

        final int[][] res = ArrayCropped.getCroppedFieldAsArray(src);
        final int[][] res2 = getCroppedFieldAsArray2(src);
        assertArrayEquals(res2, res);
    }

    public static int[][] getCroppedFieldAsArray2(int[][] src) {
        int left = Integer.MAX_VALUE;
        int right = -1;
        int top = Integer.MAX_VALUE;
        int bottom = -1;
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                if (src[i][j] == 1) {
                    if (left > j) left = j;
                    if (right < j) right = j;
                    if (top > i) top = i;
                    bottom = i;
                }
            }
        }

        final int width = right - left + 1;
        final int height = bottom - top + 1;
        final int[][] cropped = new int[height][width];

        for (int row = top, i = 0; row <= bottom; row++, i++) {
            for (int col = left, j = 0; col <= right; col++, j++) {
                cropped[i][j] = src[row][col];
            }
        }
        return cropped;
    }

}