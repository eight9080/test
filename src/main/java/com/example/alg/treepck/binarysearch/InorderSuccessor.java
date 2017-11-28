package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;


public class InorderSuccessor {

    /**
     * Given a binary search tree and a node in it,
     * find the in-order successor of that node in the BST.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root==null || p==null)
            return null;

        TreeNode next = null;
        TreeNode c = root;

        while (c!=null && c.val!=p.val){
            if(c.val>p.val){
                next=c;
                c=c.left;
            }else {
                c=c.right;
            }
        }

        if(c==null){
            return null;
        }

        if(c.right==null){
            return next;
        }
        c=c.right;
        while (c.left!=null){
            c=c.left;
        }
        return c;
    }
}
