package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {

    @Test
    public void isValidBST() throws Exception {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        assertTrue(v.isValidBST(root));
    }

    @Test
    public void isNotValidBST() throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        assertFalse(v.isValidBST(root));
    }

    @Test
    public void isNotValidBST2() throws Exception {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        root.left=node1;
        root.right=node2;
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(20);
        node2.left=node21;
        node2.right=node22;
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        assertFalse(v.isValidBST(root));
    }

}