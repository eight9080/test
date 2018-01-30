package com.example.alg.arraypkg;

import java.util.*;

public class SumNumbers {

    /**
     * Given an array of integers, find two nums such that they add up to a specific target number.

     The function twoSum should return indices of the two nums such that they add up to the target,
     where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
     are not zero-based.

     For example:

     Input: nums={2, 7, 11, 15}, target=9
     Output: index1=0, index2=1
     */

    public static int[] twoSum(int[] nums, int target){
        final HashMap<Integer, Integer> numbersByPosition = new HashMap<>();
        int [] result = new int[2];

        for(int i =0; i< nums.length; i++){
            if(numbersByPosition.containsKey(nums[i])){
                int index = numbersByPosition.get(nums[i]);
                result[0] = index;
                result[1] = i;
                break;
            }else {
                numbersByPosition.put(target-nums[i], i);
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

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums==null || nums.length==0){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                final int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]) left++;
                while(left < right && nums[right] == nums[right+1]) right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return res;

    }

}
