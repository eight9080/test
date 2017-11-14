package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestNodeTest {
    @Test
    public void kthSmallest() throws Exception {

        TreeNode tree = getTree();
        SmallestNode s = new SmallestNode();
        int kthSmallest = s.kthSmallest(tree, 2);
        assertEquals(4, kthSmallest);

    }

    private TreeNode getTree(){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(2);
        node1.left=node3;
        TreeNode node4 = new TreeNode(12);
        node2.right=node4;
        return root;
    }

}