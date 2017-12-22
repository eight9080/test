package com.example.alg.dynamic;

public class Jump {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.
     */
    public boolean canJump(int[] nums) {

        if(nums.length <= 1)
            return true;

        int end = nums.length-1;

        int maxIndex = nums[0];

        for(int i=0; i< nums.length; i++){
            if(maxIndex<=i && nums[i]==0){
                return false;
            }
            if(i+nums[i]>maxIndex){
                maxIndex=i+nums[i];
            }
            if(maxIndex>=end){
                return true;
            }
        }

        return false;
    }
}
