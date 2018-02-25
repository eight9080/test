package com.example.alg.arraypkg;

public class AverageSubarray {

    /**
     * Given an array consisting of n integers, find the contiguous subarray
     * of given length k that has the maximum average value. And you need to output the maximum average value.

     Example 1:
     Input: [1,12,-5,-6,50,3], k = 4
     Output: 12.75
     Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     */
    public double findMaxAverage(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0D;
        }

        if(k>nums.length){
            return 0D;
        }

        double averageMax = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < nums.length-k+1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum+=nums[i+j];
            }
            final double currentAverage = (double)sum / (double) k;
            averageMax = Math.max(averageMax, currentAverage);
        }

        return averageMax;
    }

}
