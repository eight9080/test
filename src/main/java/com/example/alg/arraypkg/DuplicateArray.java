package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateArray {

    /**
     * 422 Find All Duplicates in an Array
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * <p>
     * Find all the elements that appear twice in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * <p>
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [2,3]
     */
    public List<Integer> findDuplicates(int[] nums) {
        //On^2
//        return Arrays.stream(nums)
//                .filter(n -> Collections.frequency(nums, n)>1)
//                .distinct()
//                .collect(Collectors.toList());

        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        Integer duplicate = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (duplicate != null && duplicate == nums[i]) {
                    continue;
                }
                duplicate = nums[i];
                result.add(duplicate);

            }
        }

        return result;
    }
}
