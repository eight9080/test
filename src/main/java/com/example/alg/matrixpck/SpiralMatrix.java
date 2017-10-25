package com.example.alg.matrixpck;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return result;

        int noRows = matrix.length;
        int noColumns = matrix[0].length;

        int x = 0;
        int y = 0;

        while (noRows>0 && noColumns>0){

            if(noRows==1){
                for(int i = 0; i<noColumns; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(noColumns==1){
                for(int i = 0; i<noRows; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }


            //top
            for(int i = 0; i< noColumns-1; i++){
                result.add(matrix[x][y++]);
            }

            //top -> bottom
            for(int i = 0; i<noRows-1; i++){
                result.add(matrix[x++][y]);
            }

            //bottom
            for(int i = 0; i<noColumns-1; i++){
                result.add(matrix[x][y--]);
            }

            //bottom -> top
            for (int i = 0; i<noRows-1; i++){
                result.add(matrix[x--][y]);
            }

            noColumns=noColumns-2;
            noRows=noRows-2;
            x++;
            y++;

        }

        return result;

    }

    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

     For example,
     Given n = 3,

     You should return the following matrix:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]
     */
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int k=1;
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;

        while(k<=n*n){

            //left -> right
            for(int i =left; i<=right; i++){
                result[top][i] = k;
                k++;
            }
            top++;

            //top-> bottom
            for(int i = top; i<= bottom; i++){
                result[i][right]=k;
                k++;
            }
            right--;

            //bottom -> left
            for(int i = right; i>=left; i--){
                result[bottom][i]=k;
                k++;
            }
            bottom--;


            //bottom-> top
            for(int i = bottom; i>=top; i--){
                result[i][left]=k;
                k++;
            }
            left++;

        }
        return result;

    }

}
