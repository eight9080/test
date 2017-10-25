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

}
