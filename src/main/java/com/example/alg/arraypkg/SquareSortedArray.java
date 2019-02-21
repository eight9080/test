package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SquareSortedArray {

    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
     *
     *
     *
     * Example 1:
     *
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Example 2:
     *
     * Input: [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     */
    public int[] sortedSquares(int[] A) {

        return Arrays.stream(A)
                .map(num -> num*num)
                .sorted()
                .toArray();



    }

}
