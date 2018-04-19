package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

public class InvertBinaryTree {
    /**
     * Invert a binary tree.

       4
     /   \
     2     7
     / \   / \
     1   3 6   9
     to
       4
     /   \
     7     2
     / \   / \
     9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {

        if(root ==null)
            return root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        left = invertTree(left);
        right = invertTree(right);

        root.right=left;
        root.left=right;

        return root;
    }
}
