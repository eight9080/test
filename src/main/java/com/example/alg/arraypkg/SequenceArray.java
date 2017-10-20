package com.example.alg.arraypkg;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SequenceArray {

    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements
     sequence should be [1, 2, 3, 4]. Its length is 4.

     Your algorithm should run in O(n) complexity.
     */
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.asList(nums);
        final Set<Integer> numbersSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 1;
        for(int elem : nums){
            int left = elem-1;
            int right = elem+1;
            int count = 1;

            while (numbersSet.contains(left)){
                count++;
                numbersSet.remove(left);
                left--;
            }

            while (numbersSet.contains(right)){
                count++;
                numbersSet.remove(right);
                right++;
            }
            max = Math.max(max, count);

        }
        return max;
    }

}
