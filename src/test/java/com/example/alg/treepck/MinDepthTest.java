package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinDepthTest {
    @Test
    public void minDepth() throws Exception {

        final MinDepth m = new MinDepth();
        final int minDepth = m.minDepth(tree());
        assertEquals(3, minDepth);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(4);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(2);
        node11.right=node21;

        TreeNode node32 = new TreeNode(5);
        node12.right=node32;

        return root;
    }

}