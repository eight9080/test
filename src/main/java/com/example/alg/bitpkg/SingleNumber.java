package com.example.alg.bitpkg;

import java.util.Arrays;

public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public int singleNumber(int[] nums) {

        return Arrays.stream(nums).reduce(0, (l, r) -> l ^ r);

    }


    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.


     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

}
