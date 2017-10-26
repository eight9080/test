package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchMatrixTest {
    @Test
    public void searchMatrix2() throws Exception {
        final SearchMatrix s = new SearchMatrix();
        int[][]matrix1 = {{1,1}};
        assertFalse(s.searchMatrix2(matrix1, 2));

        int[][]matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        assertTrue(s.searchMatrix2(matrix, 5));
        assertFalse(s.searchMatrix2(matrix, 20));

    }
    @Test
    public void searchMatrix() throws Exception {
        final SearchMatrix s = new SearchMatrix();
        int[][]matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        assertTrue(s.searchMatrix(matrix, 3));

    }

}