package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

public class RecoverTree {

    TreeNode firstNode;
    TreeNode secondNode;

    TreeNode prevNode;

    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.

     Recover the tree without changing its structure.

     */

    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }

        inorder(root);
        if(firstNode!=null && secondNode!=null){
            int val = firstNode.val;
            firstNode.val=secondNode.val;
            secondNode.val=val;
        }
    }

    private void inorder(TreeNode root) {
        if(root==null){
            return;
        }

        inorder(root.left);

        if(prevNode==null){
            prevNode=root;
        }else {

            if(root.val< prevNode.val){

                if(firstNode==null){
                    firstNode=prevNode;
                }
                secondNode=root;
            }
            prevNode=root;
        }

        inorder(root.right);

    }

}
