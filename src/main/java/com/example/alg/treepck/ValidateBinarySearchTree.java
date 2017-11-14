package com.example.alg.treepck;

public class ValidateBinarySearchTree {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
     Example 1:
     2
     / \
     1   3
     Binary tree [2,1,3], return true.
     Example 2:
     1
     / \
     2   3
     Binary tree [1,2,3], return false.
     */
    public boolean isValidBST(TreeNode root) {

        if(root==null){
            return true;
        }

        return isValidBstHelper(root, null, null);

    }

    private boolean isValidBstHelper(TreeNode root, Integer min, Integer max) {

        if(root==null){
            return true;
        }
        if(min !=null && min>= root.val ){
            return false;
        }
        if(max!=null && max <=root.val){
            return false;
        }

        if(root.left!=null){
            boolean valid = isValidBstHelper(root.left, min, root.val);
            if(!valid)
                return false;
        }

        if(root.right!=null){
            boolean valid = isValidBstHelper(root.right, root.val, max);
            if(!valid)
                return false;
        }

        return true;
    }

}
