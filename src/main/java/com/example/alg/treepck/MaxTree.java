package com.example.alg.treepck;

import java.util.Deque;
import java.util.LinkedList;

public class MaxTree {

    /**
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

     The root is the maximum number in the array.
     The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     Construct the maximum tree by the given array and output the root node of this tree.

     Example 1:
     Input: [3,2,1,6,0,5]
     Output: return the tree root node representing the following tree:

     6
     /   \
     3     5
     \    /
     2  0
     \
     1
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        Deque<TreeNode> stack = new LinkedList<>();
        for (final int num : nums) {
            final TreeNode current = new TreeNode(num);

            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            stack.push(current);

        }

        return stack.isEmpty()? null : stack.removeLast();
    }
}
