package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized
 * with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {

   private Deque<TreeNode> stackNodes = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {

        while (root!=null){
            stackNodes.push(root);
            root=root.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stackNodes.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stackNodes.pop();
        int result = node.val;
        if(node.right!=null){
            node=node.right;
            while (node!=null){
                stackNodes.push(node);
                node=node.left;
            }
        }
        return result;
    }

}
