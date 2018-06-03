package com.example.alg.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sequences {

    /**
     * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
     *
     * Example:
     * Input: [4, 6, 7, 7]
     * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * Note:
     * The length of the given array will not exceed 15.
     * The range of integer in the given array is [-100,100].
     * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
     */
    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, result, 0, new ArrayList<>());

        final ArrayList<List<Integer>> lists = new ArrayList<>(result);
        return lists;

    }

    private void dfs(int[] nums, Set<List<Integer>> result, int index, List<Integer> current) {
        if (current.size() > 1) {
            result.add(new ArrayList<>(current));
        }

        if(index>=nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (current.isEmpty() || current.get(current.size() - 1) <= nums[i]) {
                current.add(nums[i]);
                dfs(nums, result, i + 1, current);
                current.remove(current.size() - 1);
            }

        }

    }
}
