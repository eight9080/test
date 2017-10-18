package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class SummaryRanges {

    /**
     * Given a sorted integer array without duplicates,
     * return the summary of its ranges for consecutive numbers.

     For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
     */
    public List<String> summaryRanges(int[] nums) {
        if(nums==null || nums.length==0){
            return Collections.emptyList();
        }

        if(nums.length==1){
            return Collections.singletonList(nums[0] + "");
        }

        List<String> result = new ArrayList<>();

        int firstRange = nums[0];
        int prevNum = firstRange;

        for(int i = 1; i<nums.length; i++){
            //break range
            if(prevNum+1!=nums[i]) {
                if (firstRange == prevNum) {
                    result.add(firstRange + "");
                } else {
                    result.add(firstRange + "->" + prevNum);
                }
                firstRange = nums[i];
            }
            prevNum=nums[i];
        }

        //check last number
        if(firstRange==prevNum){
            result.add(firstRange+"");
        }else{
            result.add(firstRange+"->"+prevNum);
        }

        return result;
    }
}
