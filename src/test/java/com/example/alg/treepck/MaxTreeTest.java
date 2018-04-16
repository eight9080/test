package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTreeTest {

    @Test
    public void constructMaximumBinaryTree() {

        final MaxTree m = new MaxTree();
        final TreeNode treeNode = m.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        assertEquals(tree(), treeNode);
    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(2);
        node1.right=node3;
        TreeNode node11 = new TreeNode(1);
        node3.right=node11;

        TreeNode node4 = new TreeNode(0);
        node2.left=node4;
        return root;
    }
}