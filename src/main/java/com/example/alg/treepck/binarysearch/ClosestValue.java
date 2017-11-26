package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

public class ClosestValue {

    /**
     * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.


     */

    int goal;
    double min = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }

    private void helper(TreeNode root, double target) {
        if(root==null){
            return;
        }
        final double diff = Math.abs(root.val - target);
        if(diff <min){
            min = diff;
            goal=root.val;
        }

        if(target<root.val){
            helper(root.left, target);
        }else {
            helper(root.right, target);
        }

    }
}
