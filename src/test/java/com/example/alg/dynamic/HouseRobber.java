package com.example.alg.dynamic;

import com.example.alg.treepck.TreeNode;

public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

     Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     */
    public int rob(int[] nums) {
        if(nums==null|| nums.length==0){
            return 0;
        }

        int maxEven = 0;
        int maxOdd = 0;

        for(int i = 0; i<nums.length; i++){
            if(i % 2 == 0){
                maxEven+=nums[i];
                maxEven = maxEven>maxOdd? maxEven: maxOdd;
            }else {
                maxOdd+=nums[i];
                maxOdd=maxOdd>maxEven? maxOdd: maxEven;
            }
        }
        return Math.max(maxEven, maxOdd);
    }

    public int robDP(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }


    /**
     * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

     Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     */
    public int rob2(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int max1 = robDP(nums, 0, nums.length-2);
        int max2 = robDP(nums, 1, nums.length-1);

        return Math.max(max1, max2);

    }

    private int robDP(int[] nums, int start, int end) {
        if(start==end){
            return nums[start];
        }

        int[] robs = new int[nums.length];
        robs[start] = nums[start];
        robs[start+1] = Math.max(robs[start], nums[start+1]);

        for(int i = start+2; i<=end; i++){
            robs[i] = Math.max(robs[i-2]+nums[i], robs[i-1]);
        }

        return robs[end];

    }

    /**
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

     Determine the maximum amount of money the thief can rob tonight without alerting the police.

     Example 1:
     3
     / \
     2   3
     \   \
     3   1
     Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     Example 2:
     3
     / \
     4   5
     / \   \
     1   3   1
     Maximum amount of money the thief can rob = 4 + 5 = 9.
     */
    public int rob3(TreeNode root) {
        if(root == null)
            return 0;

        int [] sumWithAndWithoutRoot = robSum(root);
        return Math.max(sumWithAndWithoutRoot[0], sumWithAndWithoutRoot[1]);

    }

    private int[] robSum(TreeNode root) {

        if(root == null){
            int[] result = {0, 0};
            return result;
        }


        int[] result = new int[2];

        final int[] leftSum = robSum(root.left);
        final int[] rightSum = robSum(root.right);

        // 0 is when root is selected, 1 is when not
        result[0] = root.val + leftSum[1]+rightSum[1];
        result[1] = Math.max(leftSum[0], leftSum[1]) + Math.max(rightSum[0], rightSum[1]);

        return result;
    }
}
