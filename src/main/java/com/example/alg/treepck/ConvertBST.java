package com.example.alg.treepck;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertBST {
    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     * <p>
     * Example:
     * <p>
     * Input: The root of a Binary Search Tree like this:
     * 5
     * /   \
     * 2     13
     * <p>
     * Output: The root of a Greater Tree like this:
     * 18
     * /   \
     * 20     13
     */
    public TreeNode convertBST(TreeNode root) {

        TreeNode result = root;

        Deque<TreeNode> nodesToVisit = new ArrayDeque<>();
        TreeNode temp = root;
        int sum = 0;
        while (temp != null || !nodesToVisit.isEmpty()) {

            while (temp!=null){
                nodesToVisit.push(temp);
                temp=temp.right;
            }
            final TreeNode node = nodesToVisit.pop();
            sum+=node.val;
            node.val=sum;
            temp=node.left;

        }

        return result;
    }
}