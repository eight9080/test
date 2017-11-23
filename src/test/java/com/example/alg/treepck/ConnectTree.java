package com.example.alg.treepck;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConnectTree {

    /**
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * Initially, all next pointers are set to NULL.
     * <p>
     * Note:
     * <p>
     * You may only use constant extra space.
     * You may assume that it is a perfect binary tree
     * (ie, all leaves are at the same level, and every parent has two children).
     * For example,
     * Given the following perfect binary tree,
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 4  5  6  7
     * After calling your function, the tree should look like:
     * 1 -> NULL
     * /  \
     * 2 -> 3 -> NULL
     * / \  / \
     * 4->5->6->7 -> NULL
     */
    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeLinkNode> nodes1 = new ArrayDeque<>();
        Deque<TreeLinkNode> nodes2 = new ArrayDeque<>();
        nodes1.push(root);

        while (!nodes1.isEmpty()) {
            final TreeLinkNode node = nodes1.remove();

            if (node.left != null) {
                nodes2.add(node.left);
            }
            if (node.right != null) {
                nodes2.add(node.right);
            }


            if (nodes1.isEmpty()) {
                nodes1.addAll(nodes2);
                while (!nodes2.isEmpty()) {
                    final TreeLinkNode node1 = nodes2.remove();
                    final TreeLinkNode node2 = nodes2.peek();
                    node1.next = node2;
                }
            }

        }


    }

}
