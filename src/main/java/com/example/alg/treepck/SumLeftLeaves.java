package com.example.alg.treepck;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SumLeftLeaves {
    /**
     * Find the sum of all left leaves in a given binary tree.

     Example:

     3
     / \
     9  20
     /  \
     15   7

     There are two left leaves in the binary tree,
     with values 9 and 15 respectively. Return 24.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int result = 0;
        Deque<TreeNode> nodesToVisit = new ArrayDeque<>();
        TreeNode temp = root;

        while (temp!=null || !nodesToVisit.isEmpty()){
            if(temp!=null){
                nodesToVisit.push(temp);
                temp=temp.left;
                if(temp!=null && temp.left==null && temp.right==null){
                    result+=temp.val;
                }
            }else {
                final TreeNode node = nodesToVisit.poll();
                temp=node.right;
            }
        }
        return result;

    }
}
