package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueTree {

    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     */
    public int numTrees(int n) {

        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;

        for(int i = 2; i<=n; i++){
            for(int j = 0; j< i; j++){
                 nums[i ] = nums[i] + nums[j]* nums[i-j-1];/** node is root**/
            }
        }
        return nums[n];
    }

    public List<TreeNode> generateTrees(int n) {

        if(n==0){
            return new ArrayList<>();
        }

        return generateTrees(1, n);

    }

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
        }

        for(int i = start; i<=end; i++){
            final List<TreeNode> left = generateTrees(start, i - 1);
            final List<TreeNode> right = generateTrees(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){

                    final TreeNode root = new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    result.add(root);

                }
            }

        }


        return result;
    }

}
