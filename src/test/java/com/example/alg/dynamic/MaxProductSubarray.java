package com.example.alg.dynamic;

public class MaxProductSubarray {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

     For example, given the array [2,3,-2,4],
     the contiguous subarray [2,3] has the largest product = 6.

     */
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int max = nums[0];
        int min = nums[0];

        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int l1 = max * nums[i];
            int l2 = min * nums[i];
            if(nums[i]>0){
                max = Math.max(nums[i], l1);
                min = Math.min(nums[i], l2);
            }else {
                max = Math.max(nums[i], l2);
                min = Math.min(nums[i], l1);
            }

            result = Math.max(result, max);
        }
        return result;
    }
}
