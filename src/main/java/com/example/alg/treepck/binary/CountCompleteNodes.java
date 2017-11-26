package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

public class CountCompleteNodes {

    /**
     * Given a complete binary tree, count the number of nodes.

     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last,
     is completely filled, and all nodes in the last level are as far left as possible.

     It can have between 1 and 2h nodes inclusive at the last level h.
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int heightLeft = getHeightLeft(root)+1;
        int heightRight = getHeightRight(root)+1;

        if(heightLeft==heightRight){
            return (2<<(heightLeft-1))-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;

    }

    private int getHeightLeft(TreeNode node) {
        if(node==null){
            return 0;
        }
        int height = 0;

        while (node.left!=null){
            height++;
            node=node.left;
        }

        return height;
    }

    private int getHeightRight(TreeNode node) {
        if(node==null){
            return 0;
        }
        int height = 0;

        while (node.right!=null){
            height++;
            node=node.right;
        }

        return height;
    }

}
