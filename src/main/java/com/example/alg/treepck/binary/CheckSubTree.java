package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class CheckSubTree {
    /**
     * T1 and T2
     * check if T2 is a subtree of T1
     */
    boolean containsSubtree(TreeNode t1, TreeNode t2){
        if(t2 ==null){
            return true;
        }

        return  subTree(t1, t2);

    }

    private boolean subTree(TreeNode t1, TreeNode t2) {

        if(t1==null){
            return false;
        }

        if(t1.val==t2.val && matchTree(t1, t2)){
            return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null){
            return true;
        }

        if(t1 ==null || t2 ==null){
            return false;
        }

        if(t1.val!=t2.val){
            return false;
        }

        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

}
