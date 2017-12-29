package com.example.alg.dynamic;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.

     For example,
     Given [10, 9, 2, 5, 3, 7, 101, 18],
     The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

     Your algorithm should run in O(n2) complexity.
     */
    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        List<Integer> seq = new ArrayList<>();


        for (int num: nums) {
            int lastIndex = seq.size() - 1;
            if(seq.isEmpty() || seq.get(lastIndex)<num){
                seq.add(num);
                continue;
            }

            int startIndex = 0;
            while (startIndex<lastIndex){
                final int mid = (startIndex + lastIndex) / 2;
                if(seq.get(mid)<num){
                    startIndex = mid+1;
                }else {
                    lastIndex=mid;
                }
            }
            seq.set(lastIndex, num);
        }

        return seq.size();
    }
}
