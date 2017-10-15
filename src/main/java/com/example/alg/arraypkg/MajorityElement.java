package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that
     * appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array.
     Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     You may assume that the array is non-empty and the majority element always exist in the array.
     related question: Majority Element II
     brute force solution is to count. one O(n) solution is to keep track of the major number from the beginning,
     in this way the major number may vary during the process, but at the end, only the real major number will remain.
     for each pair of number,
     if they are same increase count of major number, if not, this pair will be removed.
     */
    public int majorityElement1(int[] nums) {

        int count = 0;
        int major = 0;
        for(int val : nums){
            if(count == 0){
                major = val;
                count =1;
                continue;
            }
            if(major == val) {
                count++;
            }
            else {
                count--;
            }
        }
        return major;

    }

    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * The algorithm should run in linear time and in O(1) space.
     */
    public List<Integer> majorityElement2(int[] nums) {
        Integer num1 =null;
        Integer num2 =null;
        int count1 = 0;
        int count2 = 0;
        for(int val: nums){
            if(num1!=null && num1==val){
                count1++;
            }else if(num2!=null && num2==val){
                count2++;
            }else if(count1==0){
                num1=val;
                count1=1;
            }else if(count2==0){
                num2=val;
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for (int val: nums){
            if(val == num1){
                count1++; continue;
            }
            if(num2!=null && val==num2){
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        final int minOccurances = nums.length / 3;
        if(count1>0 && count1>minOccurances){
            result.add(num1);
        }
        if(num2!=null && count2>0 && count2>minOccurances){
            result.add(num2);
        }
        return result;
    }
}
