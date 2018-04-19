package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class ZigZagTree {
    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        boolean right = true;

        while (!stack.isEmpty()) {
            final int size = stack.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = stack.pop();
                if (right) {
                    current.add(node.val);
                } else {
                    current.add(0, node.val);
                }
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }

            }
            result.add(current);
            right = !right;
        }

        return result;
    }
}
