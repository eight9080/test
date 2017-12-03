package com.example.alg.segmenttreepck;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */
public class NumArray {

    SegTreeNode root;

    public NumArray(int[] nums) {

        if(nums==null || nums.length==0)
            return;

        root = buildTree(nums, 0, nums.length-1);

    }

    private SegTreeNode buildTree(int[] nums, int start, int end) {
        if(start>end){
            return null;
        }

        if(start==end){
            return new SegTreeNode(start, end, nums[start]);
        }

        int middle = (start+end)/2;

        final SegTreeNode left = buildTree(nums, start, middle);
        final SegTreeNode right = buildTree(nums, middle+1, end);

        final SegTreeNode node = new SegTreeNode(start, end, left.sum + right.sum);
        node.leftChild=left;
        node.rightChild=right;
        return node;
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    private int sumRangeHelper(SegTreeNode node, int start, int end) {
        if(node==null || start>end){
            return 0;
        }

        if(node.start>=start && node.end<=end){
            return node.sum;
        }

        int middle = (node.start+node.end)/2;

        final int leftSum = sumRangeHelper(node.leftChild, start, Math.min(middle, end));
        final int rightSum = sumRangeHelper(node.rightChild, Math.max(start, middle+1), end);


        return leftSum+rightSum;
    }


}
