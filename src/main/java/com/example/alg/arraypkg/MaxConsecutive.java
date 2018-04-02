package com.example.alg.arraypkg;

public class MaxConsecutive {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.

     Example 1:
     Input: [1,1,0,1,1,1]
     Output: 3
     Explanation: The first two digits or the last three digits are consecutive 1s.
     The maximum number of consecutive 1s is 3.
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int current = 0;

        for (int num : nums) {
            if (num == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        max = Math.max(max, current);

        return max;
    }
}
