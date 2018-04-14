package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiameterTreeTest {


    @Test
    public void diameterOfBinaryTree1() {

        final DiameterTree d = new DiameterTree();
        TreeNode root = new TreeNode(1);
        assertEquals(0, d.diameterOfBinaryTree(root));
    }

    @Test
    public void diameterOfBinaryTree() {

        final DiameterTree d = new DiameterTree();
        assertEquals(3, d.diameterOfBinaryTree(tree()));
    }


    private TreeNode tree(){
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        node1.left=node11;
        node1.right=node12;
        return root;
    }
}