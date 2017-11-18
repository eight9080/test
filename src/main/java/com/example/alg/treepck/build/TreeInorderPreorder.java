package com.example.alg.treepck.build;

import com.example.alg.treepck.TreeNode;

public class TreeInorderPreorder {

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * in-order:   4 2 5 (1) 6 7 3 8
     pre-order: (1) 2 4 5  3 7 6 8
     From the pre-order array, we know that first element is the root.
     We can find the root in in-order array.
     Then we can identify the left and right sub-trees of the root
     from in-order array.

     Using the length of left sub-tree, we can identify left
     and right sub-trees in pre-order array.
     Recursively, we can build up the tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int inStart = 0;
        int inEnd = inorder.length - 1;
        int preStart = 0;
        int preEnd = preorder.length - 1;

        return buildTree(inorder, inStart, inEnd, preorder, preStart, preEnd);

    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int positionRoot = getPosition(inorder, rootValue);

        TreeNode left = buildTree(inorder, inStart, positionRoot - 1,
                preorder, preStart + 1, preStart + (positionRoot - inStart));

        TreeNode right = buildTree(inorder, positionRoot + 1, inEnd,
                preorder, preStart + ( positionRoot - inStart) +1, preEnd);

        root.left=left;
        root.right=right;
        return root;

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
