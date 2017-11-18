package com.example.alg.treepck.build;

import com.example.alg.treepck.TreeNode;

public class TreeInorderPostorder {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.

     Analysis

     This problem can be illustrated by using a simple example.

     in-order:   4 2 5  (1)  6 7 3 8
     post-order: 4 5 2  6 7 8 3  (1)
     From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.

     Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.

     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);

    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        TreeNode rootNode = new TreeNode(rootValue);

        int rootPosition = getPosition(inorder, rootValue);

        TreeNode left = buildTree(inorder, inStart, rootPosition - 1,
                postorder, postStart,
                postStart + rootPosition - (inStart + 1));

        TreeNode right = buildTree(inorder, rootPosition + 1, inEnd, postorder,
                postStart + rootPosition - inStart, postEnd - 1);

        rootNode.left=left;
        rootNode.right=right;

        return rootNode;

    }

    private int getPosition(int[] inorder, int rootValue) {
        for(int i = 0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                return i;
            }
        }
        return -1;
    }
}
