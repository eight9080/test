package com.example.alg.arraypkg;

public class PeekOps {

    /**
     * A peak element is an element that is greater than its neighbors. Given an input array where nums[i] ≠ nums[i+1],
     * find a peak element and return its index. The array may contain multiple peaks,
     * in that case return the index to any one of the peaks is fine.

     You may imagine that nums[-1] = nums[n] = -∞. For example, in array [1, 2, 3, 1], 3
     is a peak element and your function should return the index number 2.
     */
    public static int findPeakElement(int[] nums) {
        int index = 0;
        int max = nums[0];
        for(int i= 1; i< nums.length-1; i++){
            int prev = nums[i-1];
            int current = nums[i];
            int next = nums[i+1];

            if(prev < current && current>next && current>max){
                index = i;
                max = current;
            }
        }

        if(nums[nums.length-1]> max){
            index = nums.length-1;
        }

        return index;
    }
}
