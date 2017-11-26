package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDepthTest {
    @Test
    public void maxDepth() throws Exception {

        final MaxDepth m = new MaxDepth();
        final int maxDepth = m.maxDepth(tree());
        assertEquals(3, maxDepth);


    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node22 = new TreeNode(5);
        node11.right=node22;

        return root;
    }

}