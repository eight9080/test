package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTest {
    @Test
    public void isSymmetric() throws Exception {

        final Symmetric s = new Symmetric();
        final boolean symmetric = s.isSymmetric(treeSymmetric());
        assertTrue(symmetric);
    }

    private TreeNode treeSymmetric(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(3);
        TreeNode node22 = new TreeNode(4);
        node11.left=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(3);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

    @Test
    public void isAsymmetric() throws Exception {

        final Symmetric s = new Symmetric();
        final boolean symmetric = s.isSymmetric(treeAsymetric());
        assertFalse(symmetric);
    }

    private TreeNode treeAsymetric(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        root.left=node11;
        root.right=node12;
        TreeNode node22 = new TreeNode(3);
        node11.right=node22;

        TreeNode node32 = new TreeNode(3);
        node12.right=node32;

        return root;
    }

}