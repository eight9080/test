package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

public class SameTree {
    /**
     * Given two binary trees, write a function to check if they are the same or not.

     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


     Example 1:

     Input:     1         1
     / \       / \
     2   3     2   3

     [1,2,3],   [1,2,3]

     Output: true
     Example 2:

     Input:     1         1
     /           \
     2             2

     [1,2],     [1,null,2]

     Output: false
     Example 3:

     Input:     1         1
     / \       / \
     2   1     1   2

     [1,2,1],   [1,1,2]

     Output: false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return checkTree(p,q);

    }

    private boolean checkTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }

        if(p.val!=q.val){
            return false;
        }

        if(!checkTree(p.left, q.left)){
            return false;
        }

        if(!checkTree(p.right, q.right)){
            return false;
        }
        return true;
    }
}
