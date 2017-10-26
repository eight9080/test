package com.example.alg.matrixpck;

public class SearchMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.
     For example,

     Consider the following matrix:

     [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target = 3, return true.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while (start<=end){

            int middle = (start+end)/2;
            int middleX = middle/n;
            int middleY = middle%n;

            if(matrix[middleX][middleY]==target){
                return true;
            }

            if(matrix[middleX][middleY]>target){
                end=middle-1;
            }else{
                start=middle+1;
            }

        }
        return false;
    }

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:

     Integers in each row are sorted in ascending from left to right.
     Integers in each column are sorted in ascending from top to bottom.
     For example,

     Consider the following matrix:

     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     Given target = 5, return true.

     Given target = 20, return false.
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;

        int x = 0;
        int y = n;

        while (x<=m && y>=0){
            final int val = matrix[x][y];
            if(val ==target){
                return true;
            }

            if(val>target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }

}
