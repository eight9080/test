package com.example.alg.arraypkg;

import java.util.*;

public class MoveOps {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.
     * <p>
     * For example, given nums = [0, 1, 0, 3, 12],
     * after calling your function, nums should be [1, 3, 12, 0, 0].
     */
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int pos = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                if (pos != i) {
                    nums[i] = 0;
                }
                pos++;
            }
            i++;
        }


    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Set<Integer> distinctElems = new HashSet<>();
        for (int val : nums) {
            if (!distinctElems.add(val)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct
     * indices i and j in the array such that nums[i] = nums[j] and the absolute difference
     * between i and j is at most k.
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Map<Integer, Integer> numByIndex = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(numByIndex.containsKey(nums[i])){
                final Integer pos1 = numByIndex.get(nums[i]);
                if (Math.abs(pos1-i)<=k) {
                    return true;
                }
            }
            numByIndex.put(nums[i], i);
        }
        return false;

    }

    /**
     * Given an array of integers, find out whether there are two distinct indices i and j
     * in the array such that the absolute difference between nums[i] and nums[j] is
     * at most t and the absolute difference between i and j is at most k.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums==null||nums.length<2||k<0||t<0)
            return false;

        TreeSet<Long> sortedElems = new TreeSet<>();

        for(int i = 0; i< nums.length; i++){

            final long num = (long)nums[i];

            final long left = num - t;
            final long right = num + t+1;
            final SortedSet<Long> foundElems = sortedElems.subSet(left, right);
            if(!foundElems.isEmpty()){
                return true;
            }
            sortedElems.add(num);

            if(i>=k){
                sortedElems.remove((long)nums[i-k]);
            }

        }
        return false;


    }


}
