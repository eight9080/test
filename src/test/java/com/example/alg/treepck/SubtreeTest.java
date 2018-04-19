package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubtreeTest {

    @Test
    public void isSubtree() {
        final Subtree s = new Subtree();
        assertTrue(s.isSubtree(tree1(), tree2()));

    }

    private TreeNode tree1(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        node1.left=node3;
        node1.right=node11;

        return root;
    }
    private TreeNode tree2(){
        TreeNode node1 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        node1.left=node3;
        node1.right=node11;
        return node1;
    }
}