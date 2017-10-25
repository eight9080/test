package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchMatrixTest {
    @Test
    public void searchMatrix() throws Exception {
        final SearchMatrix s = new SearchMatrix();
        int[][]matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        assertTrue(s.searchMatrix(matrix, 3));

    }

}