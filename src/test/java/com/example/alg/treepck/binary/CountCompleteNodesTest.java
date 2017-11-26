package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountCompleteNodesTest {
    @Test
    public void countNodes() throws Exception {

        final CountCompleteNodes c = new CountCompleteNodes();
        final int nodes = c.countNodes(tree());
        assertEquals(7, nodes);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node11.left=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(6);
        TreeNode node32 = new TreeNode(7);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

    @Test
    public void countNodes1() throws Exception {

        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        root.left=node11;

        final CountCompleteNodes c = new CountCompleteNodes();
        final int nodes = c.countNodes(root);
        assertEquals(2, nodes);

    }

}