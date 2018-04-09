package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumLeftLeavesTest {

    @Test
    public void sumOfLeftLeaves() {

        final SumLeftLeaves s = new SumLeftLeaves();
        assertEquals(24, s.sumOfLeftLeaves(getTree()));

    }

    private TreeNode getTree(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left=node1;
        root.right=node2;

        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left=node3;
        node2.right=node4;
        return root;
    }

    @Test
    public void sumOfLeftLeaves2() {

        final SumLeftLeaves s = new SumLeftLeaves();
        assertEquals(4, s.sumOfLeftLeaves(getTree2()));

    }

    private TreeNode getTree2(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left=node3;
        node1.right=node4;

        return root;
    }
}