package com.example.alg.treepck;

public class DiameterTree {

    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

     Example:
     Given a binary tree
     1
     / \
     2   3
     / \
     4   5
     Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     */
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }

        maxDepth(root);
        return max;
    }


    private int maxDepth(TreeNode node) {

        if(node==null){
            return 0;
        }

        final int left = maxDepth(node.left);
        final int right = maxDepth(node.right);

        max = Math.max(max, left+right);

        return Math.max(left, right)+1;
    }
}
