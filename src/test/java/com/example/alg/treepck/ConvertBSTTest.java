package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBSTTest {

    @Test
    public void convertBST() {
        final ConvertBST c = new ConvertBST();
        final TreeNode treeNode = c.convertBST(getTree());
        assertEquals(expectTree(), treeNode);
    }

    private TreeNode getTree(){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(13);
        root.left=node1;
        root.right=node2;

        return root;
    }

    private TreeNode expectTree(){
        TreeNode root = new TreeNode(18);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(13);
        root.left=node1;
        root.right=node2;

        return root;
    }
}