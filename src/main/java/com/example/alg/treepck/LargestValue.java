package com.example.alg.treepck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LargestValue {

    /**
     * You need to find the largest value in each row of a binary tree.

     Example:
     Input:

     1
     / \
     3   2
     / \   \
     5   3   9

     Output: [1, 3, 9]
     */
    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> maxElementsByRow = new ArrayList<>();

        LinkedList<TreeNode> listToBeVisited = new LinkedList<>();
        listToBeVisited.add(root);

        while (!listToBeVisited.isEmpty()){
            final int size = listToBeVisited.size();
            Integer max = null;
            for (int i = 0; i < size; i++) {
                final TreeNode currentNode = listToBeVisited.removeFirst();
                max = max!=null ? Math.max(currentNode.val, max): currentNode.val;
                if(currentNode.left!=null) {
                    listToBeVisited.add(currentNode.left);
                }
                if(currentNode.right!=null) {
                    listToBeVisited.add(currentNode.right);
                }
            }
            maxElementsByRow.add(max);
        }
        return maxElementsByRow;
    }



}
