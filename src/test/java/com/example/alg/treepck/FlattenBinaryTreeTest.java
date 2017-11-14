package com.example.alg.treepck;

import com.example.alg.treepck.traversal.Preorder;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreeTest {
    @Test
    public void flatten() throws Exception {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        root.left=node1;
        root.right=node2;
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(4);
        node1.left=node11;
        node1.right=node12;
        TreeNode node21 = new TreeNode(6);
        node2.right=node21;

        FlattenBinaryTree f = new FlattenBinaryTree();
        f.flatten(root);

        System.out.println(Preorder.print(root));
        System.out.println(Preorder.print(expect()));

        assertEquals(expect(), root);

    }

    private TreeNode expect(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.right=node1;
        TreeNode node2 = new TreeNode(3);
        node1.right=node2;
        TreeNode node11 = new TreeNode(4);
        node2.right=node11;
        TreeNode node12 = new TreeNode(5);
        node11.right=node12;
        TreeNode node21 = new TreeNode(6);
        node12.right=node21;
        return root;
    }

}