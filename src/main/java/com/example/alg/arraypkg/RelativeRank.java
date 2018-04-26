package com.example.alg.arraypkg;

import java.util.*;
import java.util.stream.Collectors;

public class RelativeRank {

    /**
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

     Example 1:
     Input: [5, 4, 3, 2, 1]
     Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
     For the left two athletes, you just need to output their relative ranks according to their scores.
     */
    public String[] findRelativeRanks(int[] nums) {

        final List<Integer> sorted = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Map<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < sorted.size(); i++) {
            final Integer elem = sorted.get(i);
            if(i==0){
                rankMap.put(elem, "Gold Medal");
            }
            if(i==1){
                rankMap.put(elem, "Silver Medal");
            }
            if(i==2){
                rankMap.put(elem, "Bronze Medal");
            }
            if(i>2){
                rankMap.put(elem, ""+(i+1));
            }
        }

        final String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = rankMap.get(nums[i]);
        }
        return result;
    }
}
