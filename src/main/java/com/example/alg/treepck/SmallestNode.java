package com.example.alg.treepck;

import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestNode {

    /**
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. (1 ≤ k ≤ BST's total elements)
     */
    public int kthSmallest(TreeNode root, int k) {

        if(root==null)
            return 0;

        if(k==0)
            return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode p = root;

        while (!stack.isEmpty() || p!=null){

            if(p!=null){
                stack.push(p);
                p=p.left;
            }else {
                TreeNode node = stack.pop();
                k--;//lower count
                if(k==0){
                    return node.val;
                }
                p=node.right;
            }

        }

        return 0;
    }
}
