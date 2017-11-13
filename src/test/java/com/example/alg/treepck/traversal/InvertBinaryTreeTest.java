package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {
    @Test
    public void invertTree() throws Exception {

        TreeNode root = new TreeNode(4);
        TreeNode node11 = new TreeNode(2);
        TreeNode node21 = new TreeNode(7);
        root.left=node11;
        root.right=node21;
        TreeNode node111 = new TreeNode(1);
        TreeNode node112 = new TreeNode(3);
        node11.left=node111;
        node11.right=node112;
        TreeNode node211 = new TreeNode(6);
        TreeNode node212 = new TreeNode(9);
        node21.left=node211;
        node21.right=node212;

        InvertBinaryTree i = new InvertBinaryTree();
        TreeNode treeNode = i.invertTree(root);

        TreeNode expectedNode = getExpectedNode();


        System.out.println(BinaryTreeOrderTraversal.print(expectedNode));
        System.out.println(BinaryTreeOrderTraversal.print(treeNode));

        assertEquals(expectedNode, treeNode);

    }

    private TreeNode getExpectedNode(){
        TreeNode root = new TreeNode(4);
        TreeNode node11 = new TreeNode(7);
        TreeNode node21 = new TreeNode(2);
        root.left=node11;
        root.right=node21;
        TreeNode node111 = new TreeNode(9);
        TreeNode node112 = new TreeNode(6);
        node11.left=node111;
        node11.right=node112;
        TreeNode node211 = new TreeNode(3);
        TreeNode node212 = new TreeNode(1);
        node21.left=node211;
        node21.right=node212;
        return root;
    }

}