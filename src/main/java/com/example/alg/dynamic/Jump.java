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

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lastStep = 0;
        int maxStep = 0;
        int noStep = 0;

        for (int i = 0; i <= maxStep && i < nums.length; i++) {

            if(i > lastStep){
                lastStep=maxStep;
                noStep++;
            }

            maxStep = Math.max(nums[i]+i, maxStep);
        }

        if(maxStep<nums.length-1){
            return 0;
        }
        return noStep;
    }
}
