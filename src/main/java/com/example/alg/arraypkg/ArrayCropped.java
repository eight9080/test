package com.example.alg.arraypkg;

public class ArrayCropped {

    /**
     * You need to crop an array of ints, such as if it is an image and you want to crop a specific segment from it in the graphics editor to remove the maximum amount of the background and leave only the object you intrested in.

     The background consists of 0.
     The object consists of 1.

     For example the Array:

     {0,1,0,0},
     {0,0,1,0},
     {1,1,1,0},
     {0,0,0,0}
     After the cropping will look like:

     {0,1,0},
     {0,0,1},
     {1,1,1}
     */
    public static int[][] getCroppedFieldAsArray(int[][] src) {
        int topRow = 0;
        int leftColumn = 0;
        int rightColumn = 0;
        int bottomRow = 0;


        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                if(src[i][j]==1){
                        topRow = Math.min(topRow, i);
                        leftColumn = Math.min(leftColumn, j);
                        rightColumn = Math.max(rightColumn, j);
                        bottomRow = Math.max(bottomRow, i);
                }
            }
        }

        int[][] result = new int[bottomRow+1][rightColumn+1];
        int resultRow = 0;
        for (int i = topRow; i < bottomRow+1; i++) {
            int resultColumn=0;
            for (int j = leftColumn; j < rightColumn+1; j++) {
                result[resultRow][resultColumn] = src[i][j];
                resultColumn++;
            }
            resultRow++;
        }
        return  result;
    }
}
