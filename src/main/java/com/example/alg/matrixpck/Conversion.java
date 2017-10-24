package com.example.alg.matrixpck;

public class Conversion {
    /**
     * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
     * Do it in place.
     * <p>
     * Analysis
     * <p>
     * This problem should be solved in place, i.e., no other array should be used.
     * We can use the first column and the first row to track if a row/column should be set to 0.
     * <p>
     * Since we used the first row and first column to mark the zero row/column,
     * the original values are changed.
     */
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        final int length = matrix[0].length;

        //check first column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        //check first row
        for (int j = 0; j < length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        //mark zeroes on first row
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //set zeroes
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //set first column and row
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int i = 0; i < length; i++)
                matrix[0][i] = 0;
        }


    }
}