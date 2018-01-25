package com.example.alg.bitpkg;

import java.util.Arrays;

public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public int singleNumber(int[] nums) {

        return Arrays.stream(nums).reduce(0, (l, r) -> l ^ r);

    }

}
