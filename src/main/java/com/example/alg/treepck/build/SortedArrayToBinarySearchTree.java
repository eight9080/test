package com.example.alg.treepck.build;

import com.example.alg.treepck.TreeNode;

public class SortedArrayToBinarySearchTree {
/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0)
        return null;

    return sortedArrayToBST(nums, 0, nums.length - 1);
}

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int middle = (start+end)/2;
        int rootValue = nums[middle];

        TreeNode root = new TreeNode(rootValue);

        root.left = sortedArrayToBST(nums, start, middle - 1);
        root.right = sortedArrayToBST(nums, middle+1, end);

        return root;
    }


}
