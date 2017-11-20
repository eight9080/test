package com.example.alg.treepck;

public class Balanced {
    /**
     * Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as a
     binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int height = getHeight(root);
        return height != -1;

    }

    private int getHeight(TreeNode root) {
        if(root==null)
            return 0;

        final int leftHeight = getHeight(root.left);
        if(leftHeight==-1){
            return -1;
        }
        final int rightHeight = getHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }

        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }

        return 1+ Math.max(leftHeight, rightHeight);
    }
}
