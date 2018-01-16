package com.example.alg.mathpck;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,3], a solution is:

     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0){
            return list;
        }
        dfsSubsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private void dfsSubsets(int start, int[] nums, List<Integer> current, List<List<Integer>> list) {
        list.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            dfsSubsets(i+1, nums, current, list);
            current.remove(current.size()-1);

        }

    }
}
