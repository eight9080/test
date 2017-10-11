package com.example.alg.arraypkg;

import java.util.Arrays;

public class Candy {
    /**
     * There are N children standing in a line. Each child is assigned a rating value.
     You are giving candies to these children subjected to the following requirements:
     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?
     Two passes:
     left to right, if a[i] > a[i-1], increase the candy of i by 1, if not set it as 1.
     right to left, if a[i-1] > a[i], BUT count is less, then increase candy of i.
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] bombons = new int[ratings.length];

        bombons[0] = 1;

        //ASC
        for(int i = 1;i < ratings.length; i++){
            if(ratings[i-1]<ratings[i]){
                bombons[i] = bombons[i-1]+1;
            }else{
                bombons[i] = 1;
            }
        }
//        System.out.println(Arrays.toString(bombons));
        int result = bombons[ratings.length-1];
        //DESC
        for(int i = ratings.length-1;i>0; i--){
            if(ratings[i-1]>ratings[i] && bombons[i-1]<=bombons[i]){
                bombons[i-1] = bombons[i]+1;
            }
            result+=bombons[i-1];
        }
//        System.out.println(Arrays.toString(bombons));

        return result;
    }
}
