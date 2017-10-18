package com.example.alg.arraypkg;

public class MoveOps {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.

     For example, given nums = [0, 1, 0, 3, 12],
     after calling your function, nums should be [1, 3, 12, 0, 0].

     */
    public void moveZeroes(int[] nums) {

        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        int pos = 0;

        int i = 0;
        while (i<nums.length){
            if(nums[i]!=0){
                nums[pos]=nums[i];
                if(pos!=i) {
                    nums[i] = 0;
                }
                pos++;
            }
            i++;
        }


    }

}
