package com.example.alg.arraypkg;

import java.util.stream.IntStream;

/**
 * Given an array of integers your solution should find the smallest integer.

 For example:
 Given [34, 15, 88, 2] your solution will return 2
 Given [34, -345, -1, 100] your solution will return -345
 You can assume, for the purpose of this kata, that the supplied array will not be empty.
 */
public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {

        if(args.length==1){
            return args[0];
        }

        int min = args[0];
        for (int i = 1; i <args.length ; i++) {
            min = Math.min(min, args[i]);
        }
        return min;
    }

    public static int findSmallestInt2(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }

}
