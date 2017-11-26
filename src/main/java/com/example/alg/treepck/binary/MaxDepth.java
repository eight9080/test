package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

public class MaxDepth {

    /**
     * Given a binary tree, find its maximum depth.

     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {

        return maxDepth(root, 0);

    }

    private int maxDepth(TreeNode node, int level) {
        if(node==null){
            return level;
        }

        final int maxDepthLeft = maxDepth(node.left, level + 1);
        final int maxDepthRight = maxDepth(node.right, level + 1);

        return Math.max(maxDepthLeft, maxDepthRight);

    }

}
