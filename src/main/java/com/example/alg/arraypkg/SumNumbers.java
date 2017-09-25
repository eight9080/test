package com.example.alg.arraypkg;

import java.util.HashMap;

public class SumNumbers {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target,
     where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
     are not zero-based.

     For example:

     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=0, index2=1
     */

    public static int[] twoSum(int[] numbers, int target){
        final HashMap<Integer, Integer> numbersByPosition = new HashMap<>();
        int [] result = new int[2];

        for(int i =0; i< numbers.length; i++){
            if(numbersByPosition.containsKey(numbers[i])){
                int index = numbersByPosition.get(numbers[i]);
                result[0] = index;
                result[1] = i;
                break;
            }else {
                numbersByPosition.put(target-numbers[i], i);
            }
        }
        return result;
    }

    /**
     * input array is sorted
     */
    public static int[] twoSumSortedArray(int[] numbers, int target){
        if(numbers==null || numbers.length==0){
            return null;
        }
        int i = 0;
        int j = numbers.length-1;

        while (i<j){
            int x = numbers[i] + numbers[j];
            if(x<target){
                i++;
            }else if(x<target){
                j--;
            }else{
                return new int[]{i,j};
            }
        }
        return null;
    }

    /**
     * Minimum Size Subarray Sum (Java)
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
     has the minimal length of 2 under the problem constraint.
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==1)
            return 0;

        int result = nums.length;

        int start=0;
        int sum=0;
        int i=0;
        boolean exists = false;

        while(i<=nums.length){
            if(sum>=s){
                exists=true; //mark if there exists such a subarray
                if(start==i-1){
                    return 1;
                }

                result = Math.min(result, i-start);
                sum=sum-nums[start];
                start++;

            }else{
                if(i==nums.length)
                    break;
                sum = sum+nums[i];
                i++;
            }
        }

        if(exists)
            return result;
        else
            return 0;
    }

}
