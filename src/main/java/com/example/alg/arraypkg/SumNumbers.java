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

    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

     Note: The solution set must not contain duplicate quadruplets.

     For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

     A solution set is:
     [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
     ]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

            if(nums==null || nums.length==0){
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(nums);


            for (int i = 0; i < nums.length-3; i++) {

                if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) //too large
                    continue;
                if(nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target) //too small
                    continue;
                if(i>0 && nums[i-1]==nums[i]) //duplicate
                    continue;

                for (int j = i+1; j < nums.length-2 ; j++) {
                    if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) //too large
                        continue;
                    if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target) //too small
                        continue;
                    if(j>i+1 && nums[j-1]==nums[j]) //duplicate
                        continue;

                    int start = j+1;
                    int end = nums.length-1;
                    int fixSum= nums[i]+nums[j];
                    while (start<end){

                        int sum = fixSum+ nums[start]+nums[end];
                        if(sum==target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                            while (start<end && nums[start]==nums[start+1])
                                start++;
                            while (start<end && nums[end]==nums[end-1])
                                end--;
                            start++;
                            end--;
                        }else {
                            if(sum<target){
                                start++;
                            }else {
                                end--;
                            }
                        }

                    }

                }

            }
            return res;

    }

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

     For example, given array S = {-1 2 1 -4}, and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

     */
    public int threeSumClosest(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left<right){
                final int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum)<Math.abs(target-min)){
                    min = sum;
                }
                if(sum>target){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return min;

    }

    /**
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

     Example 1:
     Input:nums = [1,1,1], k = 2
     Output: 2
     Note:
     The length of the array is in range [1, 20,000].
     The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */
    public int subarraySum(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {

            sum+=num;
            count+=preSum.getOrDefault(sum-k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);

        }
        return count;
    }

    /**
     * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

     Example 1:
     Input: [23, 2, 4, 6, 7],  k=6
     Output: True
     Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     Example 2:
     Input: [23, 2, 6, 4, 7],  k=6
     Output: True
     Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {

            sum+=nums[i];
            if(k!=0){
                sum%=k;
            }
            final Integer prevPosition = map.get(sum);
            if(prevPosition!=null ){
                if(i-prevPosition>1)
                    return true;
            }else {
                map.put(sum, i);
            }

        }
        return false;
    }
    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

     To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

     Example:

     Input:
     A = [ 1, 2]
     B = [-2,-1]
     C = [-1, 2]
     D = [ 0, 2]

     Output:
     2

     Explanation:
     The two tuples are:
     1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> sumCounts = new HashMap<>();

        for (int aA : A) {
            for (int aB : B) {
                final int sum = aA + aB;
                sumCounts.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int numberTuples = 0;
        for (int aC : C) {
            for (int aD : D) {
                final int sum = aC + aD;
                numberTuples += sumCounts.getOrDefault(sum * -1, 0);

            }
        }

        return numberTuples;
    }


}
